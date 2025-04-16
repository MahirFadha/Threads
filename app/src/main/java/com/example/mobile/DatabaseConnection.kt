package com.example.mobile

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

@OptIn(DelicateCoroutinesApi::class)
fun insertPost(name:String, content: String){
    GlobalScope.launch(Dispatchers.IO) {
        val connection = DatabaseConnection.connection()
        if (connection != null) {
            try {
                val sql = "INSERT INTO post (username, content, created_at) VALUES (?,?,NOW())"
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

@OptIn(DelicateCoroutinesApi::class)
fun getLatestContent(callback: (String?) -> Unit) {
    GlobalScope.launch(Dispatchers.IO) {
        var content: String? = null
        val connection = DatabaseConnection.connection()
        if (connection != null) {
            try {
                val sql = "SELECT content FROM post ORDER BY created_at DESC LIMIT 1"
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery(sql)

                if (resultSet.next()) {
                    content = resultSet.getString("content")
                }

                resultSet.close()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }

        withContext(Dispatchers.Main) {
            callback(content)
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun getAllContents(callback: (List<String>) -> Unit) {
    GlobalScope.launch(Dispatchers.IO) {
        val contents = mutableListOf<String>()
        val connection = DatabaseConnection.connection()

        if (connection != null) {
            try {
                val sql = "SELECT content FROM post ORDER BY created_at DESC"
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery(sql)

                while (resultSet.next()) {
                    val content = resultSet.getString("content")
                    contents.add(content)
                }

                resultSet.close()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }

        // Kembalikan hasil ke thread UI
        withContext(Dispatchers.Main) {
            callback(contents)
        }
    }
}

