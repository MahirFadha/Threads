package com.example.mobile.Login

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import android.graphics.Typeface
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.CustomView.btnImportIg
import com.example.mobile.DatabaseConnection
import com.example.mobile.R
import com.example.mobile.insertData
import com.example.mobile.ui.theme.MobileTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondActivity : ComponentActivity(){
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                IsiProfil()
            }
        }
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseConnection.connection()
            if (connection != null) {
                    println("Koneksi Berhasil")
            } else {
                println("Koneksi gagal")
            }
        }
    }
}


@Composable
fun IsiProfil() {
    AndroidView(
        factory = { context ->
            val layout = ConstraintLayout(context).apply {
                setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT
                )
            }

            val btnBack = Button(context).apply {
                id = View.generateViewId()
                setBackgroundResource(R.drawable.baseline_arrow_back_24)
                layoutParams = LayoutParams(
                    90,
                    90
                )
            }

            btnBack.setOnClickListener{
                val back = Intent(context, MainActivity::class.java)
                context.startActivity(back)
            }

            val btnNext = Button(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.baseline_arrow_forward_24)
                layoutParams = LayoutParams(
                    90,
                    90
                )
            }

            val header = TextView(context).apply {
                id = View.generateViewId()
                text ="Profile"
                setTypeface(null,Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 32f
            }

            val textduwa = TextView(context).apply {
                id = View.generateViewId()
                text ="Customize your Threads profile"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
            }

            val bgProfil = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_profil))
                layoutParams = LayoutParams(900,740)
            }

            val profil = TextView(context).apply {
                id = View.generateViewId()
                text = "Name"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val iconpw = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_pw))
                layoutParams = LayoutParams(50,50)
            }

            val name = EditText(context).apply {
                id = View.generateViewId()
                hint = "Name"
                textSize = 14f
                background = null
                ellipsize = TextUtils.TruncateAt.END
                maxLines = 1
                setHintTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = ConstraintLayout.LayoutParams(
                    600,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
            }

            val line1 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = LayoutParams(600,1)
            }

            val addphoto = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.addphoto))
                layoutParams = LayoutParams(140,140)
            }

            val bio = TextView(context).apply {
                id = View.generateViewId()
                text = "Bio"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val tulisbio = EditText(context).apply{
                id = View.generateViewId()
                hint = "+ Write Bio"
                width = 200
                textSize = 14f
                ellipsize = TextUtils.TruncateAt.END
                background = null
                maxLines = 1
                setHintTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = ConstraintLayout.LayoutParams(
                    800,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
            }

            val line2 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = LayoutParams(800,1)
            }

            val link = TextView(context).apply {
                id = View.generateViewId()
                text = "Link"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val tambahlink = EditText(context).apply{
                id = View.generateViewId()
                width = 200
                hint = "+ Add link"
                textSize = 14f
                background = null
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                setHintTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = ConstraintLayout.LayoutParams(
                    800,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
            }

            val line3 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = LayoutParams(800,1)
            }

            val btnimport = btnImportIg(context).apply {
                id = View.generateViewId()
            }

            layout.addView(btnBack)
            layout.addView(btnNext)
            layout.addView(header)
            layout.addView(textduwa)
            layout.addView(bgProfil)
            layout.addView(profil)
            layout.addView(iconpw)
            layout.addView(addphoto)
            layout.addView(name)
            layout.addView(line1)
            layout.addView(bio)
            layout.addView(tulisbio)
            layout.addView(line2)
            layout.addView(link)
            layout.addView(tambahlink)
            layout.addView(line3)
            layout.addView(btnimport)

            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)

            constraintSet.connect(btnBack.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,60)
            constraintSet.connect(btnBack.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,60)

            constraintSet.connect(btnNext.id, ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,60)
            constraintSet.connect(btnNext.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,60)

            constraintSet.connect(header.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 200)
            constraintSet.connect(header.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(header.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(textduwa.id, ConstraintSet.TOP, header.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(textduwa.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textduwa.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(bgProfil.id, ConstraintSet.TOP, textduwa.id, ConstraintSet.BOTTOM,300)
            constraintSet.connect(bgProfil.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(bgProfil.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(profil.id, ConstraintSet.TOP, bgProfil.id, ConstraintSet.TOP,50)
            constraintSet.connect(profil.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(iconpw.id, ConstraintSet.TOP, profil.id, ConstraintSet.TOP,100)
            constraintSet.connect(iconpw.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line1.id, ConstraintSet.TOP, iconpw.id, ConstraintSet.TOP,100)
            constraintSet.connect(line1.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(name.id, ConstraintSet.TOP, profil.id, ConstraintSet.TOP,80)
            constraintSet.connect(name.id, ConstraintSet.START, iconpw.id, ConstraintSet.START,60)

            constraintSet.connect(addphoto.id, ConstraintSet.TOP, bgProfil.id, ConstraintSet.TOP,50)
            constraintSet.connect(addphoto.id, ConstraintSet.END, bgProfil.id, ConstraintSet.END,60)

            constraintSet.connect(bio.id, ConstraintSet.TOP, line1.id, ConstraintSet.BOTTOM,50)
            constraintSet.connect(bio.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(tulisbio.id, ConstraintSet.TOP, bio.id, ConstraintSet.TOP,80)
            constraintSet.connect(tulisbio.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line2.id, ConstraintSet.TOP, tulisbio.id, ConstraintSet.TOP,100)
            constraintSet.connect(line2.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(link.id, ConstraintSet.TOP, line2.id, ConstraintSet.BOTTOM,50)
            constraintSet.connect(link.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(tambahlink.id, ConstraintSet.TOP, link.id, ConstraintSet.TOP,80)
            constraintSet.connect(tambahlink.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line3.id, ConstraintSet.TOP, tambahlink.id, ConstraintSet.TOP,100)
            constraintSet.connect(line3.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(btnimport.id, ConstraintSet.TOP, bgProfil.id, ConstraintSet.BOTTOM,40)
            constraintSet.connect(btnimport.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(btnimport.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            fun saveUserData(username: String){
                val sharedPreferences = context.getSharedPreferences("UserPreference", MODE_PRIVATE)

                val editor = sharedPreferences.edit()

                editor.putString("username",username)

                editor.apply()
            }

            btnNext.setOnClickListener{
                if (name.text.isNotEmpty() && tulisbio.text.isNotEmpty() && tambahlink.text.isNotEmpty()){
                    val Nama = name.text.toString()
                    val Bio = tulisbio.text.toString()
                    val Link = tambahlink.text.toString()
                    insertData(Nama,Bio,Link)
                    val next = Intent(context, ThirdActivity::class.java)
                    saveUserData(Nama)
                    context.startActivity(next)
                }else{
                    Toast.makeText(context, "Isi semua data dengan benar", Toast.LENGTH_SHORT).show()
                }
            }

            constraintSet.applyTo(layout)
            layout
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSecond(){
    MobileTheme {
        IsiProfil()
    }
}