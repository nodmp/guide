package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import kotlin.properties.Delegates

class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    lateinit var view: View //延迟初始化
    var viewNullable: View? = null //可以为空的变量设置 这个变量可以设置空和正常值

    var awidth: Int = 0
    var aheight: Int = 0
    lateinit var rectF: RectF
    lateinit var rectFPadding: RectF
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    companion object {
        val WIDTH = Utils.dp2dx(110f)
    }

    lateinit var bitmap: Bitmap

    init {
        bitmap = getAvatar(WIDTH.toInt())

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        awidth = w
        aheight = h
        rectF = RectF(
            (width - bitmap.width) / 2f,
            (height - bitmap.height) / 2f,
            (width - bitmap.width) / 2f + bitmap.width.toFloat(),
            (height - bitmap.height) / 2f + bitmap.height.toFloat()
        )
        rectFPadding = RectF(
            (width - bitmap.width) / 2f -10f,
            (height - bitmap.height) / 2f-10f,
            (width - bitmap.width) / 2f + bitmap.width.toFloat()+10f,
            (height - bitmap.height) / 2f + bitmap.height.toFloat()+10f
        )

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas.saveLayer()
//        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        paint.color = resources.getColor(R.color.colorPrimary)
        canvas?.drawArc(rectFPadding, 0f, 360f, false, paint)
        var saveLayer = canvas?.saveLayer(rectF, paint)
        canvas?.drawArc(
            rectF,
            0f,
            360f,
            false,
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(bitmap, rectF.left, rectF.top, paint)
        paint.xfermode = null
        canvas?.restoreToCount(saveLayer!!)

    }

    //获取头像数据
    fun getAvatar(width: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.timg, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.timg, options)
    }
}