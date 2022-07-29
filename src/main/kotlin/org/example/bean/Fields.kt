package org.example.bean


/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:04
 *@signature 我将追寻并获取我想要的答案
 */
class Fields {
    private val list: MutableList<FieldInfo> = mutableListOf()

    fun add(fieldInfo: FieldInfo) {
        list.add(fieldInfo)
    }
}

class FieldInfo(
    val accessFlag: U2,
    val nameIndex: U2,
    val descIndex: U2,
    val attrs: Attributes
)