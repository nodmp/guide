package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class CustomizeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint()

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var path = Path()
        path.addCircle(
            Utils.dp2dx(50f),
            Utils.dp2dx(50f),
            Utils.dp2dx(50f),
            Path.Direction.CCW
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            canvas?.clipOutRect(
//                Utils.dp2dx(50f),
//                Utils.dp2dx(50f),
//                Utils.dp2dx(150f),
//                Utils.dp2dx(150f)
//            )
        }


        ///////////反着写思维方式

        canvas?.rotate(180f, width / 2f, height / 2f)

        canvas?.translate(width / 2 - Utils.dp2dx(50f), height / 2 - Utils.dp2dx(50f))
        canvas?.clipPath(path) //含有锯齿效果，谨慎使用
        //反着写？？？？
        canvas?.translate(-Utils.dp2dx(40f), -Utils.dp2dx(30f))
        var avatar = Utils.getAvatar(resources, Utils.dp2dx(150f).toInt())
        canvas?.drawBitmap(avatar, 0f, 0f, paint)
//        canvas?.rotate(90f)
        //////变换使用View坐标系
        //////绘制使用canvns 坐标系



    }
}