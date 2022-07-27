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

    override fun toString(): String {
        return String(toHex())
    }

}