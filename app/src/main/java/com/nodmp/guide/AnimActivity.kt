package com.nodmp.guide

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.animation.ValueAnimator.RESTART
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nodmp.guide.customize_view.Utils
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)
        //补间动画有限
//        imageview.animate()
//            .translationY(Utils.dp2dx(400f))
//            .rotation(320f)
//            .translationX(Utils.dp2dx(200f)).alpha(1f)
//            .setDuration(1000)
//            .start( )
//        var animator: ObjectAnimator = ObjectAnimator.ofFloat(circle, "radius", Utils.dp2dx(150f))
//        animator.startDelay = 1000
//        animator.start()
        //AnimatorSet //集合


//        var bottomAnim: ObjectAnimator = ObjectAnimator.ofFloat(circle, "bottomX", 45f)
//        bottomAnim.duration = 1000
//        bottomAnim.repeatMode = ValueAnimator.RESTART
//        bottomAnim.repeatCount =ValueAnimator.INFINITE
//        var rotateAnim: ObjectAnimator = ObjectAnimator.ofFloat(circle, "rotate", 360f)
//        rotateAnim.duration = 1000
//        rotateAnim.repeatMode = ValueAnimator.RESTART
//        rotateAnim.repeatCount =ValueAnimator.INFINITE
//        var topAnim: ObjectAnimator = ObjectAnimator.ofFloat(circle, "bottomX", 0f)
//        topAnim.duration = 1000
//        topAnim.repeatMode = ValueAnimator.RESTART
//        topAnim.repeatCount = ValueAnimator.INFINITE
//        var set = AnimatorSet()
//        set.playSequentially(bottomAnim, rotateAnim, topAnim)
//        set.start()

        var firstHolder = PropertyValuesHolder.ofFloat("bottomX", 45f)
        var sencondHolder = PropertyValuesHolder.ofFloat("rotate", 360f)
        var thirdHolder = PropertyValuesHolder.ofFloat("topX", -45f)
        var animator =
            ObjectAnimator.ofPropertyValuesHolder(circle, firstHolder, sencondHolder, thirdHolder)
        animator.setDuration(1800).start()

    }
}