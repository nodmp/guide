package com.nodmp.guide.customize_view

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.nodmp.guide.R

object Utils {
    //搞清楚头条方案中的适配问题
    fun dp2dx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            Resources.getSystem().displayMetrics
        )
    }
    //////////////////////////toutiao density/////////
    /// 最终目标
    //// px =  density * dp
    //// px = (dpi / 160) * dp
    //// dpi 的取得取决于手机的分辨率
    ////          ———————————
    ///     根号下/宽*宽 + 高*高
    ///dpi = ------------------
    ///       尺寸
    //🌰  如果 360 宽度设计稿 那么按照预想
    //view = 360dp全屏了
    //但是如果我们是1080 * 1920 屏幕 尺寸 5"
    //那么 dp = 440
    //按照 1080px / (440 /160) = 392.7dp //所以使用360不能满足屏幕
    //头条思想的核心是按照一个纬度进行适配，例如 feed流高度不需要适配
    //之前是
    // 360 就代表了 全屏
    // 1080 / 360  = demsity //就是这样
    fun getAvatar(resources:Resources,width: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.timg, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.timg, options)
    }

}