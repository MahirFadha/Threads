package com.example.mobile.Login

import android.content.Context
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
import android.widget.ImageView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.CustomView.btnContinue
import com.example.mobile.profil.ProfilUtama
import com.example.mobile.R
import com.example.mobile.ui.theme.MobileTheme

class ThirdActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                Privasi()
            }
        }
    }
}

@Composable
fun Privasi(){
    val sharedPreferences = LocalContext.current.getSharedPreferences("UserPreference", Context.MODE_PRIVATE)
    val username = sharedPreferences.getString("username","defaultUsername")?: "defaultUsername"
    AndroidView(
        factory = {context ->
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
                val back = Intent(context, SecondActivity::class.java)
                context.startActivity(back)
            }

            val textprivasi = TextView(context).apply{
                id = View.generateViewId()
                text = username
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 32f
            }

            val textduwa = TextView(context).apply {
                id = View.generateViewId()
                text ="Your Privacy can be different on Threads and Instagram. Leran More"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                layoutParams = LayoutParams(800,90)
            }

            val btnatas = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.bg_button_privacy_putih)
                layoutParams = LayoutParams(900,300)
            }

            val btnbawah = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.bg_btn_login)
                layoutParams = LayoutParams(900,300)
                alpha = 0.6f
            }

            val publicprofil = TextView(context).apply{
                id = View.generateViewId()
                text = "Public profile"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                setTypeface(null, Typeface.BOLD)
                textSize = 14f
            }

            val publicdesc = TextView(context).apply{
                id = View.generateViewId()
                text = "Anyone or on off Threads can see, share and interact with your content"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 14f
                width = 760
            }

            val dunia = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.earth_icon)
                layoutParams = LayoutParams(60,60)
            }

            val privateprofil = TextView(context).apply{
                id = View.generateViewId()
                text = "Private profile"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                setTypeface(null, Typeface.BOLD)
                textSize = 14f
                alpha = 0.4f
            }

            val privatedesc = TextView(context).apply{
                id = View.generateViewId()
                text = "Only your approved followers can see, share and interact with yor content"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 14f
                width = 760
                alpha = 0.4f
            }

            val kunci = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.icon_pw)
                layoutParams = LayoutParams(60,60)
                alpha = 0.4f
            }

            val btnContinue = btnContinue(context).apply{
                id = View.generateViewId()
            }

            btnContinue.setOnClickListener {
                val home = Intent(context, ProfilUtama::class.java)
                context.startActivity(home)
            }


            layout.addView(btnBack)
            layout.addView(textprivasi)
            layout.addView(textduwa)
            layout.addView(btnatas)
            layout.addView(btnbawah)
            layout.addView(publicprofil)
            layout.addView(publicdesc)
            layout.addView(dunia)
            layout.addView(privateprofil)
            layout.addView(privatedesc)
            layout.addView(kunci)
            layout.addView(btnContinue)


            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)

            constraintSet.connect(btnBack.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,60)
            constraintSet.connect(btnBack.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP, 60)

            constraintSet.connect(textprivasi.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 200)
            constraintSet.connect(textprivasi.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textprivasi.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(textduwa.id, ConstraintSet.TOP, textprivasi.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(textduwa.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textduwa.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(btnatas.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(btnatas.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            constraintSet.connect(btnatas.id, ConstraintSet.TOP, textduwa.id, ConstraintSet.BOTTOM, 380)

            constraintSet.connect(btnbawah.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(btnbawah.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            constraintSet.connect(btnbawah.id, ConstraintSet.TOP, btnatas.id, ConstraintSet.BOTTOM, 80)

            constraintSet.connect(publicprofil.id, ConstraintSet.TOP, btnatas.id, ConstraintSet.TOP, 60)
            constraintSet.connect(publicprofil.id, ConstraintSet.START, btnatas.id, ConstraintSet.START,60)

            constraintSet.connect(publicdesc.id, ConstraintSet.TOP, publicprofil.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(publicdesc.id, ConstraintSet.START, btnatas.id, ConstraintSet.START,60)

            constraintSet.connect(dunia.id, ConstraintSet.TOP, btnatas.id, ConstraintSet.TOP,56)
            constraintSet.connect(dunia.id, ConstraintSet.END, btnatas.id, ConstraintSet.END,90)

            constraintSet.connect(privateprofil.id, ConstraintSet.TOP, btnbawah.id, ConstraintSet.TOP,60)
            constraintSet.connect(privateprofil.id, ConstraintSet.START, btnbawah.id, ConstraintSet.START,60)

            constraintSet.connect(privatedesc.id, ConstraintSet.TOP, privateprofil.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(privatedesc.id, ConstraintSet.START, btnbawah.id, ConstraintSet.START,60)

            constraintSet.connect(kunci.id, ConstraintSet.TOP, btnbawah.id, ConstraintSet.TOP,56)
            constraintSet.connect(kunci.id, ConstraintSet.END, btnbawah.id, ConstraintSet.END,90)

            constraintSet.connect(btnContinue.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 20)
            constraintSet.connect(btnContinue.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(btnContinue.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.applyTo(layout)
            layout
        }
    ){}
}

@Preview(showBackground = true)
@Composable
fun PreviewPrivasi(){
    MobileTheme {
        Privasi()
    }
}