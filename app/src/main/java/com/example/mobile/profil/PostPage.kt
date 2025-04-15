package com.example.mobile.profil

import android.content.Intent
import android.graphics.Typeface
import android.widget.ImageView
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mobile.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.DatabaseConnection
import com.example.mobile.insertPost
import com.example.mobile.ui.theme.MobileTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostPage : ComponentActivity(){
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                Post()
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
fun Post(){
    AndroidView(
        factory = {context ->
            val layout = ConstraintLayout(context).apply {
                setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT
                )
            }

            val iconCancel = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_cancel)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            iconCancel.setOnClickListener {
                val back = Intent(context, ProfilUtama::class.java)
                context.startActivity(back)
            }

            val teksNewThread = TextView(context).apply{
                id = View.generateViewId()
                text = "New Thread"
                textSize = 22f
                setTextColor(ContextCompat.getColor(context, R.color.white))
                setTypeface(null, Typeface.BOLD)
            }

            val iconDraft = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_draft)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconOption = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_option_horiz)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val lineGray = ImageView(context).apply{
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_line_gray)
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,20
                )
            }

            val fotoProfilPost = ImageView(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_profil)
                clipToOutline = true
                layoutParams = LayoutParams(
                    140,140
                )
            }

            val usernamePost = TextView(context).apply{
                id= View.generateViewId()
                text= "hiyrr_f"
                isAllCaps=false
                textSize = 18f
                setTypeface(null,Typeface.NORMAL)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val teksAddTopic = TextView(context).apply{
                id = View.generateViewId()
                text = "> Add a topic"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTypeface(null,Typeface.NORMAL)
                textSize = 16f
            }

            val teksWhatsNew = EditText(context).apply{
                id = View.generateViewId()
                hint = "What's new?"
                setHintTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTypeface(null,Typeface.NORMAL)
                textSize = 16f
                ellipsize = TextUtils.TruncateAt.END
                maxLines = 10
                setSingleLine(false)

                layoutParams = LayoutParams(
                    800,
                    LayoutParams.WRAP_CONTENT
                )
            }

            val lineGrayVertikal = ImageView(context).apply{
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_line_gray)
                rotation = 90f
                layoutParams = LayoutParams(
                    150,150
                )
            }

            val fotoProfilPostMini = ImageView(context).apply{
                id = View.generateViewId()
                setImageAlpha(140)
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_profil)
                clipToOutline = true

                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconImage = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_image)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconCamera = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_camera)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconGif = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_gif)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconMic = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_mic)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconBurger = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_hamburger)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconLocation = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.post_icon_location)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val teksFooter = TextView(context).apply{
                id = View.generateViewId()
                text = "Anyone can reply & quote"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTypeface(null,Typeface.NORMAL)
                textSize = 16f
            }

            val buttonPost = Button(context).apply{
                id = View.generateViewId()
                text = "Post"
                isAllCaps = false
                setTextColor(ContextCompat.getColor(context, R.color.black))
                setBackgroundResource(R.drawable.post_bg_btn_post)
                alpha= 0.5f
                layoutParams = LayoutParams(
                    200,
                    100
                )
            }

            layout.addView(iconCancel)
            layout.addView(teksNewThread)
            layout.addView(iconDraft)
            layout.addView(iconOption)
            layout.addView(lineGray)
            layout.addView(fotoProfilPost)
            layout.addView(usernamePost)
            layout.addView(teksAddTopic)
            layout.addView(teksWhatsNew)
            layout.addView(lineGrayVertikal)
            layout.addView(fotoProfilPostMini)
            layout.addView(iconImage)
            layout.addView(iconCamera)
            layout.addView(iconGif)
            layout.addView(iconMic)
            layout.addView(iconBurger)
            layout.addView(iconLocation)
            layout.addView(teksFooter)
            layout.addView(buttonPost)

            teksWhatsNew.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Saat user mulai mengetik
                    buttonPost.alpha = if (!s.isNullOrEmpty()) 1f else 0.5f
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

            buttonPost.setOnClickListener {
                teksWhatsNew.text.isNotEmpty()
                val post = teksWhatsNew.text.toString()
                val username = usernamePost.text.toString()
                insertPost(username, post)
                val back = Intent(context, ProfilUtama::class.java)
                context.startActivity(back)
            }


            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)

            constraintSet.connect(iconCancel.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,60)
            constraintSet.connect(iconCancel.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,60)

            constraintSet.connect(teksNewThread.id, ConstraintSet.START,iconCancel.id, ConstraintSet.END,60)
            constraintSet.connect(teksNewThread.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,60)

            constraintSet.connect(iconDraft.id, ConstraintSet.END,iconOption.id, ConstraintSet.START,60)
            constraintSet.connect(iconDraft.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,68)

            constraintSet.connect(iconOption.id, ConstraintSet.END,ConstraintSet.PARENT_ID, ConstraintSet.END,60)
            constraintSet.connect(iconOption.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,68)

            constraintSet.connect(lineGray.id, ConstraintSet.END,ConstraintSet.PARENT_ID, ConstraintSet.END)
            constraintSet.connect(lineGray.id, ConstraintSet.TOP, iconCancel.id, ConstraintSet.BOTTOM,40)

            constraintSet.connect(fotoProfilPost.id, ConstraintSet.START,ConstraintSet.PARENT_ID, ConstraintSet.START,40)
            constraintSet.connect(fotoProfilPost.id, ConstraintSet.TOP, lineGray.id, ConstraintSet.BOTTOM,40)

            constraintSet.connect(usernamePost.id, ConstraintSet.TOP,lineGray.id,ConstraintSet.BOTTOM,40)
            constraintSet.connect(usernamePost.id, ConstraintSet.START, fotoProfilPost.id,ConstraintSet.END,40)

            constraintSet.connect(teksAddTopic.id, ConstraintSet.TOP,lineGray.id,ConstraintSet.BOTTOM,46)
            constraintSet.connect(teksAddTopic.id, ConstraintSet.START, usernamePost.id,ConstraintSet.END,20)

            constraintSet.connect(teksWhatsNew.id, ConstraintSet.TOP,usernamePost.id,ConstraintSet.BOTTOM,10)
            constraintSet.connect(teksWhatsNew.id, ConstraintSet.START, fotoProfilPost.id,ConstraintSet.END,40)

            constraintSet.connect(lineGrayVertikal.id, ConstraintSet.TOP,fotoProfilPost.id,ConstraintSet.BOTTOM,20)
            constraintSet.connect(lineGrayVertikal.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,34)

            constraintSet.connect(fotoProfilPostMini.id, ConstraintSet.TOP,lineGrayVertikal.id,ConstraintSet.BOTTOM,20)
            constraintSet.connect(fotoProfilPostMini.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,70)

            constraintSet.connect(iconImage.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconImage.id, ConstraintSet.START,lineGrayVertikal.id,ConstraintSet.END,40)

            constraintSet.connect(iconCamera.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconCamera.id, ConstraintSet.START,iconImage.id,ConstraintSet.END,40)

            constraintSet.connect(iconGif.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconGif.id, ConstraintSet.START,iconCamera.id,ConstraintSet.END,40)

            constraintSet.connect(iconMic.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconMic.id, ConstraintSet.START,iconGif.id,ConstraintSet.END,40)

            constraintSet.connect(iconBurger.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconBurger.id, ConstraintSet.START,iconMic.id,ConstraintSet.END,40)

            constraintSet.connect(iconLocation.id, ConstraintSet.TOP,teksWhatsNew.id,ConstraintSet.BOTTOM,80)
            constraintSet.connect(iconLocation.id, ConstraintSet.START,iconBurger.id,ConstraintSet.END,40)

            constraintSet.connect(teksFooter.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,80)
            constraintSet.connect(teksFooter.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,60)

            constraintSet.connect(buttonPost.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,60)
            constraintSet.connect(buttonPost.id, ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,60)





            constraintSet.applyTo(layout)
            layout
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPost(){
    MobileTheme {
        Post()
    }
}
