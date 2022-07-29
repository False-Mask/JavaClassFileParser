package org.example.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:04
 *@signature 我将追寻并获取我想要的答案
 */
class Attributes {
    private val list: MutableList<AttributeInfo> = mutableListOf()
    fun add(attr: AttributeInfo) {
        list.add(attr)
    }
}

data class AttributeInfo(
    val attrIndex: U2,
    val attributeLength: U4,
    val info: ByteArray
)