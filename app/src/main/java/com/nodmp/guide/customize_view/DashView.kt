package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DashView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    companion object{
        private val ANGLE = 120
        private val RADIUS = Utils.dp2dx(60f)
        private val LENGTH = Utils.dp2dx(40f)

    }
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path: Path = Path()
    lateinit var pathMeasure: PathMeasure
    lateinit var pathDashPathEffect: PathDashPathEffect

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        path.addRect(0f, 0f, Utils.dp2dx(2f), Utils.dp2dx(10f), Path.Direction.CW)
        val measurePath:Path = Path()
        measurePath.addArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90 + ANGLE / 2f,
            360f - ANGLE
        )
        pathMeasure = PathMeasure(measurePath, false)
        val fl = (pathMeasure.length-Utils.dp2dx(2f)) / 20
        pathDashPathEffect =
            PathDashPathEffect(path, fl, 0f, PathDashPathEffect.Style.ROTATE)


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90 + ANGLE / 2f,
            360f - ANGLE, false, paint

        )
        //
        paint.pathEffect = pathDashPathEffect
        canvas?.drawArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90 + ANGLE / 2f,
            360f - ANGLE, false, paint

        )
        paint.pathEffect = null
        canvas?.drawLine(
            width / 2f,
            height / 2f,
            (Math.cos(Math.toRadians(getAngleFromMark(5).toDouble())) * LENGTH).toFloat() + width / 2,
            (Math.sin(Math.toRadians(getAngleFromMark(5).toDouble())) * LENGTH).toFloat() + height / 2,
            paint

        )
//        paint.style= Paint.Style.FILL
//        paint.strokeWidth = 10f
//        paint.color = Color.BLUE
//        paint.strokeCap = Paint.Cap.ROUND
//        canvas?.drawPoint(width / 2f, height / 2f, paint)
    }
    fun getAngleFromMark(mark: Int): Int {
        return 90 + ANGLE / 2 + (360 - ANGLE) / 20 * mark
    }
}