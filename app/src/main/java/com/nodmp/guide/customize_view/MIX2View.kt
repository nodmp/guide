package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.nodmp.guide.R


class MIX2View(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var textPaint: TextPaint = TextPaint()
    var red = Utils.getAvatar(resources, 300, R.drawable.red)
    var blue = Utils.getAvatar(resources, 300, R.drawable.blue)

    ///////////////////////SRC/////////////////////////////////////////////
    var bitmapShader1: BitmapShader =
        BitmapShader(red, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    var bitmapShader2: BitmapShader =
        BitmapShader(blue, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    ///////////////////////SRC/////////////////////////////////////////////
    val shader: Shader = ComposeShader(bitmapShader1, bitmapShader2, PorterDuff.Mode.SRC_IN)

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        textPaint.textSize = 40f
//        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.shader = shader
        canvas?.drawRect(0f, 0f, 300f, 300f, paint)
        canvas?.drawText("SRC_IN", 60f, 60f, textPaint)
        
    }
}