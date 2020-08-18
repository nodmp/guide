package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View

class TestView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    /////////////////////////
    var path: Path = Path()//

    /////////////////////////
    lateinit var pathMeasure: PathMeasure

    companion object{
        val TAG:String ="TestView"
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawCircle(
//            width / 2f,
//            height / 2f,
//            Utils.dp2dx(50f),
//            paint
//
//        )
//        paint.setColor(Color.RED)
//        paint.strokeWidth = 4f
//        canvas?.drawLine(width / 2f, height / 2f, width / 1f, height / 1f, paint)
        ///从一个点 往外发射 如果是一个点就是内部 &&  0 是外
        ///不为0 就是内部 为0 就是外部
        path.fillType = Path.FillType.EVEN_ODD

//        //环形上升
//        path.fillType = Path.FillType.EVEN_ODD
//        //////////////////////////////////
//        path.fillType = Path.FillType.INVERSE_EVEN_ODD
//        path.fillType = Path.FillType.INVERSE_WINDING
        canvas?.drawPath(path, paint)


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addRect(
            width / 2 - 100f,
            height / 2 - 100f,
            width / 2 + 100f,
            height / 2 + 100f,
            Path.Direction.CCW
        )
        path.addCircle(width / 2f, height / 2f, 50f, Path.Direction.CW)
        path.addCircle(width / 2f, height / 2f, 90f, Path.Direction.CCW)
        pathMeasure = PathMeasure(path, false)
        Log.d(TAG, "onSizeChanged: " + pathMeasure.length)
        var floatArray = floatArrayOf(0f, 0f)
        var floatArray2 = floatArrayOf(0f, 0f)
        pathMeasure.getPosTan(20f, floatArray, floatArray2)
        Log.d(TAG, "onSizeChanged: ${floatArray[0]}: ${floatArray[1]}: ${floatArray2[0]}: ${floatArray2[1]}" )
        //正切值

    }
}