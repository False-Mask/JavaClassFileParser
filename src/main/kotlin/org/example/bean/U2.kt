package org.example.bean

import kotlin.experimental.and

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  21:37
 *@signature 我将追寻并获取我想要的答案
 *@description 一个两字节的数据
 */
@JvmInline
value class U2(val value: ByteArray) {

    init {
        assert(value.size == 2) {
            "U2数据结构长度必须为2"
        }
    }

    fun toHex(): ByteArray {
        return value
    }

    override fun toString(): String {
        return toHex().decodeToString()
    }

}