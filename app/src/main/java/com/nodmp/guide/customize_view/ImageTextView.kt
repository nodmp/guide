package com.nodmp.guide.customize_view

import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.core.app.CoreComponentFactory
import com.nodmp.guide.R
import kotlin.properties.Delegates

class ImageTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint: TextPaint = TextPaint()
    companion object {
        val RADIUS = Utils.dp2dx(80f)
        val RING_WIDTH = Utils.dp2dx(20f)
    }

    lateinit var bitmap: Bitmap
    var floatArray: FloatArray = floatArrayOf(0f)



    init {
        textPaint.textSize = Utils.dp2dx(12f)
        paint.textSize = Utils.dp2dx(12f)
        bitmap = getAvatar(Utils.dp2dx(80f).toInt())
    }

    fun getAvatar(width: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.timg, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.timg, options)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        paint.style = Paint.Style.STROKE
//        paint.color = resources.getColor(R.color.colorPrimary)
//        paint.strokeWidth = RING_WIDTH
//        //贴左边情况
        var str =
            "中国驻以色列使馆网站8月18日消息，近日，根据以色列当地媒体报道及以政府提供的相关信息，佩塔提克瓦市（经常被中国工友称为“北大地瓜”）某中国建筑工人聚居区暴发新冠肺炎疫情，上周五卫生部门对居住于该区域的中国工人进行统一检测，目前已有约90人确诊感染新冠病毒，均为轻症或无症状。　　据悉，检测阳性的工人已被送至指定酒店隔离或医院治疗，当地政府已将相关区域封锁隔离，检测阴性的工人须在住所继续隔离几天后再次进行检测，以免扩大感染范围，当地政府将提供食物、医疗服务等保障。　　中国驻以色列使馆将密切关注确诊中国工人状况，提供必要帮助，维护大家合法权益和健康安全。"
//        var staticLayout: StaticLayout = StaticLayout(
//            str,
//            textPaint,
//            width,
//            Layout.Alignment.ALIGN_NORMAL,
//            1f,
//            0f,
//            false
//        )
//        staticLayout.draw(canvas)

        ////////////todo
        canvas?.drawBitmap(bitmap, width - Utils.dp2dx(82f), 100f, paint)
        var int = paint.breakText(str, true, width.toFloat(), floatArray)
        canvas?.drawText(str, 0, int, 0f, 50f, paint)
        canvas?.drawText(str, 0, int, 0f, 50f + paint.fontSpacing, paint)


    }

}