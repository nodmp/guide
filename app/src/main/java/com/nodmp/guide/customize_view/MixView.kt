package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class MixView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var camera = Camera()

    init {
//        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var path = Path() //Path-:
        var bitmap = Utils.getAvatar(resources, 300)
        var bitmapShader: BitmapShader =
            BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.setShader(bitmapShader)
        canvas?.translate(width / 2f - 150f, height / 2f - 150f)
        canvas?.drawCircle(150f, 150f, 150f, paint)
    }
}