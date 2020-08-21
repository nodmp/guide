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
    var bitmap = Utils.getAvatar(resources, IMAGE_WIDTH.toInt())

    var rotate: Float = 0f
        get() = field
        set(value) {
            field = value
            invalidate()
        }
    var topX: Float = 0f
        get() = field
        set(value) {
            field = value
            invalidate()
        }

    var bottomX: Float = 0f
        get() = field
        set(value) {
            field = value
            invalidate()
        }


    companion object {
        @JvmField val PADDING = Utils.dp2dx(100f)
        @JvmField
        val IMAGE_WIDTH = Utils.dp2dx(200f)
    }

    init {
        camera.setLocation(0f, 0f, -8 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        ///Shape Top
        canvas?.save()
        canvas?.translate(width / 2f, height / 2f)
        canvas?.rotate(-rotate)
        camera.save()
        camera.rotateX(topX)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas?.clipRect(-width / 2f, -height / 2f, width / 2f, 0f)
        canvas?.rotate(rotate)
        canvas?.translate(-width / 2f, -height / 2f)
        canvas?.drawBitmap(
            bitmap,
            (width - bitmap.width) / 2f,
            (height - bitmap.height) / 2f,
            paint
        )
        canvas?.restore()

        //Shape bottom
        canvas?.save()
        canvas?.translate(width / 2f, height / 2f)
        canvas?.rotate(-rotate)
        camera.save()
        camera.rotateX(bottomX)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas?.clipRect(-width / 2f, 0f, width / 2f, height / 2f)
        canvas?.rotate(rotate)
        canvas?.translate(-width / 2f, -height / 2f)
        canvas?.drawBitmap(
            bitmap,
            (width - bitmap.width) / 2f,
            (height - bitmap.height) / 2f,
            paint
        )
        canvas?.restore()

    }
}