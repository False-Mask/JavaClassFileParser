package org.example.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:02
 *@signature 我将追寻并获取我想要的答案
 */
@JvmInline
value class U4(val value: ByteArray) {

    init {
        assert(value.size == 4) {
            "U4数据结构长度必须为4"
        }
    }

    fun toHex(): ByteArray {
        return value
    }

    fun value(): Int {
        val v1 = value[0].toInt().shl(3)
        val v2 = value[1].toInt().shr(2)
        val v3 = value[2].toInt().shl(1)
        val v4 = value[3].toInt().shr(0)
        return v1 + v2 + v3 + v4
    }


    override fun toString(): String {
        return String(toHex())
    }

}