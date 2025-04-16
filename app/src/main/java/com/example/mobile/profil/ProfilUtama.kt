package com.example.mobile.profil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import android.graphics.Typeface
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.R
import com.example.mobile.ui.theme.MobileTheme
import com.example.mobile.DatabaseConnection
import com.example.mobile.getAllContents
import com.example.mobile.getLatestContent
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ProfilUtama : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MobileTheme {
                Profil()
            }
        }
//        GlobalScope.launch(Dispatchers.IO) {
//            val connection = DatabaseConnection.connection()
//            if (connection != null) {
//                println("Koneksi Berhasil")
//            } else {
//                println("Koneksi gagal")
//            }
//        }
    }
}



@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Profil(){
    AndroidView(
        factory = { context ->
            val layout = ConstraintLayout(context).apply {
                setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT
                )
            }

            val iconPrivacy = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_earth)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconChart = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_chart)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconInstagram = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_instagram)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconSetting = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_option_horiz)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val namaAkun = TextView(context).apply{
                id = View.generateViewId()
                text = "Mahir Fadha"
                isAllCaps = false
                textSize = 28f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val username = TextView(context).apply{
                id= View.generateViewId()
                text= "hiyrr_f"
                isAllCaps=false
                textSize = 18f
                setTypeface(null,Typeface.NORMAL)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val fotoProfil = ImageView(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_profil)
                clipToOutline = true
                layoutParams = LayoutParams(
                    240,240
                )
            }

            val bio = TextView(context).apply{
                id = View.generateViewId()
                text="Belajarlah karena tanpa belajar kamu akan terajar oleh si pengajar"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 18f
                setTypeface(null, Typeface.NORMAL)
                isAllCaps = false
            }

            val fotoFollowers1 = ImageView(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_followers1)
                clipToOutline = true
                layoutParams = LayoutParams(
                    70,70
                )
            }

            val fotoFollowers2 = ImageView(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_followers2)
                clipToOutline = true
                layoutParams = LayoutParams(
                    70,70
                )
            }

            val teksFollower = TextView(context).apply{
                id = View.generateViewId()
                text = "100k followers"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTypeface(null,Typeface.NORMAL)
                textSize = 16f
            }

            val btnEditProfil = Button(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_button)
                text = "Edit Profile"
                textSize = 16f
                isAllCaps=false
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
                layoutParams = LayoutParams(
                    480,110
                )
            }

            val btnShareProfil = Button(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_button)
                text = "Share Profile"
                textSize = 16f
                isAllCaps=false
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
                layoutParams = LayoutParams(
                    480,110
                )
            }

            val threadsTeks = TextView(context).apply{
                id=View.generateViewId()
                text = "Threads"
                setTextColor(ContextCompat.getColor(context, R.color.white))
                isAllCaps=false
                textSize=16f
                setTypeface(null, Typeface.BOLD)
            }

            val repliesTeks = TextView(context).apply{
                id=View.generateViewId()
                text = "Replies"
                setTextColor(ContextCompat.getColor(context, R.color.gray))
                isAllCaps=false
                textSize=15f
                setTypeface(null, Typeface.BOLD)
            }

            val mediaTeks = TextView(context).apply{
                id=View.generateViewId()
                text = "Media"
                setTextColor(ContextCompat.getColor(context, R.color.gray))
                isAllCaps=false
                textSize=15f
                setTypeface(null, Typeface.BOLD)
            }

            val repostsTeks = TextView(context).apply{
                id=View.generateViewId()
                text = "Reposts"
                setTextColor(ContextCompat.getColor(context, R.color.gray))
                isAllCaps=false
                textSize=15f
                setTypeface(null, Typeface.BOLD)
            }

            val feedsTeks = TextView(context).apply{
                id=View.generateViewId()
                text = "Feeds"
                setTextColor(ContextCompat.getColor(context, R.color.gray))
                isAllCaps=false
                textSize=15f
                setTypeface(null, Typeface.BOLD)
            }

            val lineWhite = ImageView(context).apply{
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_line_white)
                layoutParams = LayoutParams(
                    200,20
                )
            }

            val lineGray = ImageView(context).apply{
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_line_gray)
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,20
                )
            }


            val fotoProfilPost1 = ImageView(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_foto_profil)
                setImageResource(R.drawable.profil_foto_profil)
                clipToOutline = true
                layoutParams = LayoutParams(
                    140,140
                )
            }

            val usernamePost1 = TextView(context).apply{
                id= View.generateViewId()
                text= "hiyrr_f"
                isAllCaps=false
                textSize = 17f
                setTypeface(null,Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val teksWhatsNew = TextView(context).apply{
                id = View.generateViewId()
                text = "What's new?"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
                setTypeface(null,Typeface.NORMAL)
                textSize = 16f
            }

            val lineGrayPost = ImageView(context).apply{
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_line_gray)
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,20
                )
            }



//            getLatestContent { latestContent ->
//                teksPost.text = latestContent ?: "Tidak ada postingan"
//            }

            getAllContents { contentList ->
                var previousId = lineGrayPost.id // untuk penempatan post pertama

                contentList.forEachIndexed {
                    index, content ->
                    val fotoProfilPost = ImageView(context).apply {
                        id = View.generateViewId()
                        setBackgroundResource(R.drawable.profil_bg_foto_profil)
                        setImageResource(R.drawable.profil_foto_profil)
                        clipToOutline = true
                        layoutParams = LayoutParams(140, 140)
                    }

                    val usernamePost = TextView(context).apply {
                        id = View.generateViewId()
                        text = "hiyrr_f"
                        isAllCaps = false
                        textSize = 17f
                        setTypeface(null, Typeface.BOLD)
                        setTextColor(ContextCompat.getColor(context, R.color.white))
                    }

                    val teksPost = TextView(context).apply {
                        id = View.generateViewId()
                        text = content
                        setTextColor(ContextCompat.getColor(context, R.color.white))
                        setTypeface(null, Typeface.NORMAL)
                        textSize = 16f
                    }

                    val lineGrayPost1 = ImageView(context).apply {
                        id = View.generateViewId()
                        setBackgroundResource(R.drawable.profil_line_gray)
                        layoutParams = LayoutParams(
                            LayoutParams.MATCH_PARENT, 20
                        )
                    }

                    layout.addView(fotoProfilPost)
                    layout.addView(usernamePost)
                    layout.addView(teksPost)
                    layout.addView(lineGrayPost1)

                    val constraintSet = ConstraintSet()
                    constraintSet.clone(layout)

                    constraintSet.connect(
                        fotoProfilPost.id,
                        ConstraintSet.START,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.START,
                        30
                    )
                    constraintSet.connect(
                        fotoProfilPost.id,
                        ConstraintSet.TOP,
                        previousId,
                        ConstraintSet.BOTTOM,
                        40
                    )

                    constraintSet.connect(
                        usernamePost.id,
                        ConstraintSet.START,
                        fotoProfilPost.id,
                        ConstraintSet.END,
                        60
                    )
                    constraintSet.connect(
                        usernamePost.id,
                        ConstraintSet.TOP,
                        previousId,
                        ConstraintSet.BOTTOM,
                        40
                    )

                    constraintSet.connect(
                        teksPost.id,
                        ConstraintSet.TOP,
                        previousId,
                        ConstraintSet.BOTTOM,
                        120
                    )
                    constraintSet.connect(
                        teksPost.id,
                        ConstraintSet.START,
                        fotoProfilPost1.id,
                        ConstraintSet.END,
                        60
                    )
//            constraintSet.connect(teksPost.id, ConstraintSet.END, ConstraintSet.PARENT_ID,ConstraintSet.END)

                    constraintSet.connect(
                        lineGrayPost1.id,
                        ConstraintSet.TOP,
                        fotoProfilPost.id,
                        ConstraintSet.BOTTOM,
                        40
                    )
                    constraintSet.connect(
                        lineGrayPost1.id,
                        ConstraintSet.START,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.START
                    )


                    constraintSet.applyTo(layout)

                    previousId = lineGrayPost1.id

//                    val combinedText = contentList.joinToString("\n\n")
//                    teksPost.text = combinedText
                }
            }



            val iconHome = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_home_off)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconSearch = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_search_off)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val postWrapper = FrameLayout(context).apply {
                id=View.generateViewId()
                setBackgroundResource(R.drawable.profil_bg_icon_post)
                layoutParams = LayoutParams (
                    120,100
                )
                val iconPost = ImageView(context).apply{
                    id = View.generateViewId()
                    setImageResource(R.drawable.profil_icon_post)
                    layoutParams = FrameLayout.LayoutParams(
                        80,80
                    ).apply {
                        gravity = Gravity.CENTER
                    }
                }
                addView(iconPost)
            }

            postWrapper.setOnClickListener {
                val post = Intent(context, PostPage::class.java)
                context.startActivity(post)
            }

            val iconLove = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_hearth_off)
                layoutParams = LayoutParams(
                    80,80
                )
            }

            val iconProfile = ImageView(context).apply{
                id = View.generateViewId()
                setImageResource(R.drawable.profil_icon_user_on)
                layoutParams = LayoutParams(
                    80,80
                )
            }


            layout.addView(iconPrivacy)
            layout.addView(iconChart)
            layout.addView(iconInstagram)
            layout.addView(iconSetting)
            layout.addView(namaAkun)
            layout.addView(username)
            layout.addView(fotoProfil)
            layout.addView(bio)
            layout.addView(fotoFollowers1)
            layout.addView(fotoFollowers2)
            layout.addView(teksFollower)
            layout.addView(btnEditProfil)
            layout.addView(btnShareProfil)
            layout.addView(threadsTeks)
            layout.addView(repliesTeks)
            layout.addView(mediaTeks)
            layout.addView(repostsTeks)
            layout.addView(feedsTeks)
            layout.addView(lineWhite)
            layout.addView(lineGray)
            layout.addView(fotoProfilPost1)
            layout.addView(usernamePost1)
            layout.addView(teksWhatsNew)
            layout.addView(lineGrayPost)
            layout.addView(iconHome)
            layout.addView(iconSearch)
            layout.addView(postWrapper)
            layout.addView(iconLove)
            layout.addView(iconProfile)

            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)


            constraintSet.connect(iconPrivacy.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,40)
            constraintSet.connect(iconPrivacy.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,40)

            constraintSet.connect(iconSetting.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,40)
            constraintSet.connect(iconSetting.id, ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,40)

            constraintSet.connect(iconInstagram.id, ConstraintSet.END,iconSetting.id,ConstraintSet.END,140)
            constraintSet.connect(iconInstagram.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,40)

            constraintSet.connect(iconChart.id, ConstraintSet.END,iconInstagram.id,ConstraintSet.END,140)
            constraintSet.connect(iconChart.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,40)

            constraintSet.connect(namaAkun.id, ConstraintSet.TOP,iconPrivacy.id,ConstraintSet.TOP,130)
            constraintSet.connect(namaAkun.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,40)

            constraintSet.connect(username.id, ConstraintSet.TOP,namaAkun.id,ConstraintSet.BOTTOM,18)
            constraintSet.connect(username.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,40)

            constraintSet.connect(fotoProfil.id, ConstraintSet.TOP,iconSetting.id,ConstraintSet.TOP,110)
            constraintSet.connect(fotoProfil.id, ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,40)

            constraintSet.connect(bio.id, ConstraintSet.TOP,username.id,ConstraintSet.BOTTOM,34)
            constraintSet.connect(bio.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,40)

            constraintSet.connect(fotoFollowers1.id, ConstraintSet.TOP,bio.id,ConstraintSet.BOTTOM,30)
            constraintSet.connect(fotoFollowers1.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,40)

            constraintSet.connect(fotoFollowers2.id, ConstraintSet.TOP,bio.id,ConstraintSet.BOTTOM,30)
            constraintSet.connect(fotoFollowers2.id, ConstraintSet.START,fotoFollowers1.id,ConstraintSet.START,40)

            constraintSet.connect(teksFollower.id, ConstraintSet.TOP,bio.id,ConstraintSet.BOTTOM,40)
            constraintSet.connect(teksFollower.id, ConstraintSet.START,fotoFollowers2.id,ConstraintSet.END,20)

            constraintSet.connect(btnEditProfil.id, ConstraintSet.TOP,fotoFollowers1.id,ConstraintSet.BOTTOM,70)
            constraintSet.connect(btnEditProfil.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,40)

            constraintSet.connect(btnShareProfil.id, ConstraintSet.TOP,fotoFollowers1.id,ConstraintSet.BOTTOM,70)
            constraintSet.connect(btnShareProfil.id, ConstraintSet.START, btnEditProfil.id,ConstraintSet.END,40)

            constraintSet.connect(threadsTeks.id, ConstraintSet.TOP,btnEditProfil.id,ConstraintSet.BOTTOM,60)
            constraintSet.connect(threadsTeks.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,50)

            constraintSet.connect(repliesTeks.id, ConstraintSet.TOP,btnEditProfil.id,ConstraintSet.BOTTOM,64)
            constraintSet.connect(repliesTeks.id, ConstraintSet.START, threadsTeks.id,ConstraintSet.END,76)

            constraintSet.connect(mediaTeks.id, ConstraintSet.TOP,btnEditProfil.id,ConstraintSet.BOTTOM,64)
            constraintSet.connect(mediaTeks.id, ConstraintSet.START, repliesTeks.id,ConstraintSet.END,74)

            constraintSet.connect(repostsTeks.id, ConstraintSet.TOP,btnEditProfil.id,ConstraintSet.BOTTOM,64)
            constraintSet.connect(repostsTeks.id, ConstraintSet.START, mediaTeks.id,ConstraintSet.END,76)

            constraintSet.connect(feedsTeks.id, ConstraintSet.TOP,btnEditProfil.id,ConstraintSet.BOTTOM,64)
            constraintSet.connect(feedsTeks.id, ConstraintSet.START, repostsTeks.id,ConstraintSet.END,76)

            constraintSet.connect(lineWhite.id, ConstraintSet.TOP,threadsTeks.id,ConstraintSet.BOTTOM,30)
            constraintSet.connect(lineWhite.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,34)

            constraintSet.connect(lineGray.id, ConstraintSet.TOP,threadsTeks.id,ConstraintSet.BOTTOM,34)
            constraintSet.connect(lineGray.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START)

            constraintSet.connect(fotoProfilPost1.id, ConstraintSet.TOP,lineGray.id,ConstraintSet.BOTTOM,40)
            constraintSet.connect(fotoProfilPost1.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,30)

            constraintSet.connect(usernamePost1.id, ConstraintSet.TOP,lineGray.id,ConstraintSet.BOTTOM,40)
            constraintSet.connect(usernamePost1.id, ConstraintSet.START, fotoProfilPost1.id,ConstraintSet.END,60)

            constraintSet.connect(teksWhatsNew.id, ConstraintSet.TOP,lineGray.id,ConstraintSet.BOTTOM,120)
            constraintSet.connect(teksWhatsNew.id, ConstraintSet.START, fotoProfilPost1.id,ConstraintSet.END,60)

            constraintSet.connect(lineGrayPost.id, ConstraintSet.TOP,fotoProfilPost1.id,ConstraintSet.BOTTOM,40)
            constraintSet.connect(lineGrayPost.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START)

            constraintSet.connect(iconHome.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,40)
            constraintSet.connect(iconHome.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,100)

            constraintSet.connect(iconSearch.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,40)
            constraintSet.connect(iconSearch.id, ConstraintSet.START, iconHome.id,ConstraintSet.END,110)

            constraintSet.connect(postWrapper.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,30)
            constraintSet.connect(postWrapper.id, ConstraintSet.START, iconSearch.id,ConstraintSet.END,110)

            constraintSet.connect(iconLove.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,40)
            constraintSet.connect(iconLove.id, ConstraintSet.START, postWrapper.id,ConstraintSet.END,110)

            constraintSet.connect(iconProfile.id, ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,40)
            constraintSet.connect(iconProfile.id, ConstraintSet.START, iconLove.id,ConstraintSet.END,110)


            constraintSet.applyTo(layout)
            layout
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    MobileTheme {
        Profil()
    }
}