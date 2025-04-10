package com.example.mobile.CustomView

import android.content.Context
import android.util.AttributeSet
import android.graphics.Typeface
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import androidx.core.content.ContextCompat
import com.example.mobile.R


class btnImportIg(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialButtonStyle
) : MaterialButton(context, attrs, defStyleAttr)
{

    init {
        setupButton()
    }

    private fun setupButton(){
        text = "Import from Instagram"
        setTextColor(context.getColor(R.color.white))
        isAllCaps = false
        icon = ContextCompat.getDrawable(context, R.drawable.downloadicon)
        iconGravity = ICON_GRAVITY_TEXT_START
        iconSize = 60
        textAlignment = TEXT_ALIGNMENT_CENTER
        iconTint = null
        setTypeface(null, Typeface.BOLD)
        layoutParams = ConstraintLayout.LayoutParams(
            900, 180
        )

//        background = ContextCompat.getDrawable(context, R.drawable.bg_btn_login)
        setBackgroundColor(ContextCompat.getColor(context, R.color.darkgray))
        cornerRadius = 20
//        backgroundTintList = null
    }
}