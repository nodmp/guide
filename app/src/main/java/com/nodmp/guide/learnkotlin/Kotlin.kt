package com.nodmp.guide.learnkotlin

import android.view.View
import java.util.*

class Kotlin {
    //todo 空判断
    //我很确定我用的时候绝对不为空，但第一时间我没法给它赋值
    lateinit var notNull: View
    var nullAble: View? = null
    var strInput: String? = "str" //可空类型

    init {
        //nullAble这个为可空对象，所以需要进行?.
        //safe call nullAble!=null  call
        nullAble?.setOnClickListener {}
        //丧失特性，直接进行调用
        nullAble!!.setOnClickListener {}
        notNull.setOnClickListener {}
        //没必要👇
        notNull?.setOnClickListener {}
        notNull!!.setOnClickListener {}
        ///Java @Nullable &  NonNull
        ////判断空处理 然后进行设置
        val st1 = "Hello"
        val st2: String? = "H2llo"
        v1(st1)
        v2(st2)
        st2?.let { v3(it) }
        //////////////////传递///////////
    }

    /////类型推断 X动态类型

    fun visitor() {
        var number1 = 1
        var number2 = 1.0f
        var number3 = 1.0
        var str = "Pin"
    }

    ///////可见性/////////

    //传递对象如果可空
    fun v1(string: String): Unit {
        //
    }
    //传递对象
    fun v2(string: String?): Unit {
        //
    }
    fun v3(string: String): Unit {
        //
    }

    fun base() {
        //基本类型
        var number:Int = 1
        var str: String = "World"
        var b: Boolean = true
        var array: IntArray = intArrayOf(1, 2, 3, 4)
        var c: Char = 'c'
        //box unbox
        var ms1 = 1
        var ms2: Int? = 2
        var array1: Array<Int> = Array<Int>(1,{
            it->
            1
        }) //un


    }


}