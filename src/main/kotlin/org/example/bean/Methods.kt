package org.example.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:58
 *@signature 我将追寻并获取我想要的答案
 */
class Methods {
    private val list: MutableList<MethodInfo> = mutableListOf()

    fun add(method: MethodInfo) {
        list.add(method)
    }
}

data class MethodInfo(
    val accessFlag: U2,
    val nameIndex: U2,
    val descriptionIndex: U2,
    val attributesCount: U2,
    val attributesInfo: Attributes
)

