package org.example.bean

@JvmInline
value class U1(private val value: Byte){

    fun value(): Int {
        return value.toInt()
    }

}
