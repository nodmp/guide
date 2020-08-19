package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import kotlin.properties.Delegates

class SportView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    companion object {
        val RADIUS = Utils.dp2dx(80f)
        val RING_WIDTH = Utils.dp2dx(20f)
    }

    //矩形 测量用
    var rect: Rect = Rect()
    var fontMetrics: Paint.FontMetrics = Paint.FontMetrics()


    init {
        paint.textSize = Utils.dp2dx(40f)
        paint.typeface = Typeface.createFromAsset(context?.assets, "webfont.ttf")
        paint.textAlign = Paint.Align.CENTER

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE
        paint.color = resources.getColor(R.color.colorPrimary)
        paint.strokeWidth = RING_WIDTH
        canvas?.drawCircle(width / 2f, height / 2f, RADIUS, paint)
        paint.color = resources.getColor(R.color.colorAccent)
        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            -90f,
            225f,
            false,
            paint

        )
        //绘制文字 abab
        paint.style = Paint.Style.FILL
        //固定内容就可以这么算，要不就会跳动
        paint.getTextBounds("青林", 0, "青林".length, rect)
        var offset = (rect.top + rect.bottom) / 2f
        /////////
        paint.getFontMetrics(fontMetrics)
        offset = (fontMetrics.ascent + fontMetrics.descent) / 2f
        canvas?.drawText("青林", width / 2f, height / 2f - offset, paint)
//        canvas?.drawPoint(width / 2f, height / 2f, paint)
        ////绘制文字2 贴0
        paint.color = Color.RED
        paint.textSize = Utils.dp2dx(80f)
        paint.textAlign = Paint.Align.LEFT
        paint.getTextBounds("贴Top & 贴左边", 0, "贴Top & 贴左边".length, rect)
        canvas?.drawText(
            "贴Top & 贴左边",
            (-rect.left).toFloat(),
//            0f,
            -(fontMetrics.ascent - fontMetrics.descent),
            paint
        )
        //贴左边情况



    }

}