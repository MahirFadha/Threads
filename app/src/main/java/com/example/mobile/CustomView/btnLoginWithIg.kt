package com.example.mobile.CustomView

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton
import androidx.core.content.ContextCompat
import com.example.mobile.R

class btnLoginWithIg(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialButtonStyle
) : MaterialButton(context, attrs, defStyleAttr)
{

    init {
        setupButton()
    }

    private fun setupButton(){
        text = context.getString(R.string.loginwithig)
        textAlignment = TEXT_ALIGNMENT_TEXT_START
        setTextColor(context.getColor(R.color.lightgray))
        isAllCaps = false
        icon = ContextCompat.getDrawable(context, R.drawable.logo_ig)
        iconGravity = ICON_GRAVITY_END
        iconSize = 220
        iconTint = null

        layoutParams = LinearLayout.LayoutParams(
            1000,
            220
            ).apply {
                gravity = Gravity.CENTER
                topMargin = 340
        }

        background = ContextCompat.getDrawable(context, R.drawable.bg_btn_login)
        backgroundTintList = null
    }
}