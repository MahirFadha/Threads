package com.example.mobile.CustomView

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import com.example.mobile.R
import com.google.android.material.button.MaterialButton

class btnContinue(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialButtonStyle
) : MaterialButton(context,attrs,defStyleAttr){

    init {
        setupButton()
    }

    private fun setupButton(){
        text = "Continue"
        setTextColor(context.getColor(R.color.white))
        isAllCaps = false
        textAlignment = TEXT_ALIGNMENT_CENTER
        setTypeface(null, Typeface.BOLD)
        setBackgroundColor(ContextCompat.getColor(context, R.color.darkgray))
        cornerRadius = 20
        layoutParams = LayoutParams(1000,180)
    }
}