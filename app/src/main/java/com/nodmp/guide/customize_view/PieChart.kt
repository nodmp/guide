package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.nodmp.guide.R

////一个饼状图的实现
class PieChart(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bounds: RectF = RectF()
    var angles = intArrayOf(60, 100, 120, 80)

    var colors =
        arrayOf(R.color.colorAccent, R.color.red, R.color.colorPrimary, R.color.colorPrimaryDark)




    companion object{
        val RADIUS = Utils.dp2dx(80f).toInt()
        val LENGTH = Utils.dp2dx(20f)
        val MOVE = Utils.dp2dx(10f)
        val TAG = "PieChart"
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        bounds.set(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var add: Float = 0f
        for ((index,value) in angles.withIndex()) {
            paint.color = resources.getColor(colors[index])
            if (index == 0) {
                canvas?.save()
                canvas?.translate(
                    (Math.cos(Math.toRadians((add + value / 2).toDouble())) * LENGTH).toFloat(),
                    (Math.sin(Math.toRadians((add + value / 2).toDouble())) * LENGTH).toFloat()
                )
                canvas?.drawArc(bounds, add, value.toFloat(), true, paint)
                canvas?.restore()
            } else {
                canvas?.drawArc(bounds, add, value.toFloat(), true, paint)
            }
            add += value
        }
        /////////////////////////////////////////////////////////////
//        paint.color = resources.getColor(R.color.colorAccent)
//        canvas?.drawArc(bounds, 0f, 90f, true, paint)
//        paint.color = resources.getColor(R.color.red)
//        canvas?.drawArc(bounds, 90f, 90f, true, paint)
//
//        canvas?.save()
//        Log.d(TAG, "onDraw: " + Math.cos(Math.toRadians(215.0))* LENGTH)
//        Log.d(TAG, "onDraw: " + Math.sin(Math.toRadians(215.0)) * LENGTH)
//
//        canvas?.translate(
//            (Math.cos(Math.toRadians(215.0))* LENGTH).toFloat(),
//            (Math.sin(Math.toRadians(215.0))* LENGTH).toFloat()
//        )
//        paint.color = resources.getColor(R.color.colorPrimary)
//        canvas?.drawArc(bounds, 180f, 70f, true, paint)
//        canvas?.restore()
//
//
//        paint.color = resources.getColor(R.color.view_color_list)
//        canvas?.drawArc(bounds, 250f, 110f, true, paint)
    }
}