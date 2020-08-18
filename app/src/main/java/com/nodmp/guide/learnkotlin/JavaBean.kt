package com.nodmp.guide.learnkotlin

class JavaBean {
    var name: String = "2"
        get() {
            return field + "hello world"
        }
        set(value) {
            field = "mysql " + value
        }

    init {
        name = "Hello"
        print(name)
    }

}