package com.example.mobile.Login

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.mobile.CustomView.btnLoginWithIg
import com.example.mobile.R
import com.example.mobile.ui.theme.MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                Awal()
            }
        }
    }
}

@Composable
fun Awal() {
    AndroidView(
        factory = { context ->
            val layout = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                )
            }

            val buttonlogin = btnLoginWithIg(context)

            val bg = ImageView(context).apply {
                setImageResource(R.drawable.bg_login)
                scaleType = ImageView.ScaleType.CENTER_CROP
                layoutParams = LinearLayout.LayoutParams(
                    2000,
                    1600
                ).apply {
                    gravity = Gravity.CENTER
                }
            }

            buttonlogin.setOnClickListener {
                val lanjut = Intent(context, SecondActivity::class.java)
                context.startActivity(lanjut)
            }

            layout.addView(bg,0)
            layout.addView(buttonlogin)
            layout
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileTheme {
        Awal()
    }
}