package com.nodmp.guide.anim

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import com.nodmp.guide.customize_view.Utils
import kotlin.properties.Delegates

class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radius: Float = Utils.dp2dx(20f)
    get() = field
    set(value:Float) {
        field = value
        invalidate()
    }

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = resources.getColor(R.color.colorPrimary)
        canvas?.drawCircle(width / 2f, height / 2f, radius, paint)
    }

}