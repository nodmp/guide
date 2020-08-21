package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.LightingColorFilter
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View


class MIX4View(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var textPaint: TextPaint = TextPaint()
//    var red = Utils.getAvatar(resources, 300, R.drawable.red)
//    var blue = Utils.getAvatar(resources, 300, R.drawable.blue)

    ///////////////////////SRC/////////////////////////////////////////////
//    var bitmapShader1: BitmapShader =
//        BitmapShader(red, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//    var bitmapShader2: BitmapShader =
//        BitmapShader(blue, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    ///////////////////////SRC/////////////////////////////////////////////
//    val shader: Shader = ComposeShader(bitmapShader1, bitmapShader2, PorterDuff.Mode.SRC_ATOP)
//    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        textPaint.textSize = 40f
//        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var bitmap = Utils.getAvatar(resources, 400)
//        paint.shader = shader
//        canvas?.drawRect(0f, 0f, 300f, 300f, paint)
        val lightingColorFilter: ColorFilter = LightingColorFilter(0x00ffff, 0x003000)
        textPaint.setColorFilter(lightingColorFilter)
        canvas?.drawBitmap(bitmap, 0f, 0f, textPaint)

        canvas?.drawText("这里演示Hen", 60f, 60f, textPaint)
    }
}