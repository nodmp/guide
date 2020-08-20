package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var camera = Camera()

    init {
        camera.rotateX(45f)
//        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var path = Path() //Path-:
        canvas?.save()
//        canvas?.clipRect(0f, 0f, width.toFloat(), 150 + Utils.dp2dx(80f) / 2)
        canvas?.drawBitmap(Utils.getAvatar(resources, Utils.dp2dx(80f).toInt()), 150f, 150f, paint)
        canvas?.restore()
        /////todo
        canvas?.save()
        canvas?.translate(150 + Utils.dp2dx(80f) / 2, 150 + Utils.dp2dx(80f))
        camera.applyToCanvas(canvas)
        canvas?.clipRect(-Utils.dp2dx(80f)/2, 0f,  Utils.dp2dx(80f)/2,  Utils.dp2dx(80f)/2)
        canvas?.translate(-150f - (Utils.dp2dx(80f) / 2), -150f - (Utils.dp2dx(80f) / 2))
        canvas?.drawBitmap(Utils.getAvatar(resources, Utils.dp2dx(80f).toInt()), 150f, 150f, paint)
        canvas?.restore()
//        canvas?.clipRect(0f, 150 + Utils.dp2dx(80f) / 2, width.toFloat(), height.toFloat())
//        canvas?.drawBitmap(Utils.getAvatar(resources, Utils.dp2dx(80f).toInt()), 150f, 150f, paint)
    }
}