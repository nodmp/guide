package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import kotlin.properties.Delegates

class Hencode1View(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paintDraw: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object {
        val RADIUS = Utils.dp2dx(80f)
        val RING_WIDTH = Utils.dp2dx(20f)
    }


    init {
        paint.textSize = Utils.dp2dx(40f)
        paint.typeface = Typeface.createFromAsset(context?.assets, "webfont.ttf")
        paint.textAlign = Paint.Align.CENTER

    }

  

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas?.drawColor(Color.argb(0.2f, 180f, 10f, 20f))
        }
        paint.style = Paint.Style.STROKE

        paint.color = Color.RED
        paintDraw.color = Color.WHITE
        paintDraw.style = Paint.Style.STROKE
        paintDraw.strokeWidth = Utils.dp2dx(20f)

        canvas?.drawCircle(width / 2f, height / 2f, Utils.dp2dx(40f), paintDraw)
        canvas?.drawRect(
            width / 2f - Utils.dp2dx(40f),
            height / 2f - Utils.dp2dx(40f),
            width / 2f + Utils.dp2dx(40f),
            height / 2f + Utils.dp2dx(40f),
            paint
        )
//        canvas?.drawRGB(111, 111, 111)
//        canvas?.drawARGB(20, 111, 111, 111)
        paint.strokeWidth = Utils.dp2dx(20f)
        paint.strokeCap = Paint.Cap.ROUND

        var floatArray: FloatArray = floatArrayOf(0f, 0f, 100f, 100f, 200f, 200f, 300f, 300f)
        canvas?.drawPoints(floatArray, 0, 8, paint)
        paint.strokeWidth = 1f
        canvas?.drawLine(0f, 0f, width.toFloat(), height.toFloat(), paint)
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
//        var floats:FloatArray = floatArrayOf()
//        paint?.style = Paint.Style.FILL
        paint.setColor(resources.getColor(R.color.colorPrimary))
        var rectF: RectF = RectF(100f, 100f, 300f, 300f)

        canvas?.drawOval(rectF, paint)

        canvas?.drawRoundRect(rectF, 30f, 30f, paint)
        ////////////
        paint.color = resources.getColor(android.R.color.holo_green_dark)
        canvas?.drawRect(100f - 20f, 100f - 20f, 300f + 20f, 300f + 20f, paint)

        paint.color = resources.getColor(android.R.color.holo_blue_light)
        paint.style = Paint.Style.FILL
        canvas?.drawArc(rectF, 0f, 90f, true, paint)
//        canvas?.drawPaint()
    }

}