package com.example.mobile

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseConnection {

    private const val URL = "jdbc:postgresql://10.0.2.2:5432/postgres"
    private const val USER = "postgres"
    private const val PASSWORD = "mahir"

    fun connection (): Connection?{
        return try{
            Class.forName("org.postgresql.Driver")
            DriverManager.getConnection(URL,USER, PASSWORD).also {
            }
        }catch (e: SQLException){
            e.printStackTrace()
            println("Hahahaha")
            null
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun insertData(name:String, bio: String, link:String){
    GlobalScope.launch(Dispatchers.IO) {
        val connection = DatabaseConnection.connection()
        if (connection != null) {
            try {
                val sql = "INSERT INTO account (username, bio, link) VALUES (?,?,?)"
                val statement = connection.prepareStatement(sql)
                statement.setString(1, name)
                statement.setString(2, bio)
                statement.setString(3, link)
                statement.executeUpdate()
                println("Data berhasil dimasukkan")
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }
    }
}

fun insertPost(name:String, content: String){
    GlobalScope.launch(Dispatchers.IO) {
        val connection = DatabaseConnection.connection()
        if (connection != null) {
            try {
                val sql = "INSERT INTO account (username, content, created_at) VALUES (?,?,NOW)"
                val statement = connection.prepareStatement(sql)
                statement.setString(1, name)
                statement.setString(2, content)
                statement.executeUpdate()
                println("Data berhasil dimasukkan")
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }
    }
}
