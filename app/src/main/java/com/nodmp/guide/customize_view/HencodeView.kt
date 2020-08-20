package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import kotlin.properties.Delegates

class HencodeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path: Path = Path()
    var path2: Path = Path()

    companion object {

    }


    init {
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.lineTo(w / 2f, h / 2f)
        path.lineTo(w.toFloat(), h / 2f)
        path.lineTo(w.toFloat(), 0f)
        path.lineTo(0f, 0f)

        path2.moveTo(0f, h.toFloat())
        path2.lineTo(w / 2f, h / 2f)
        path2.lineTo(w.toFloat(), h / 2f)
        path2.lineTo(w.toFloat(), h.toFloat())
        path2.lineTo(0f, h.toFloat())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = resources.getColor(R.color.red)
        canvas?.drawPath(path, paint)

        paint2.color = resources.getColor(R.color.colorPrimary)
        canvas?.drawPath(path2, paint2)



    }

}