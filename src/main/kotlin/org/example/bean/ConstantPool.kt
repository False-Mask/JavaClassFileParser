package org.example.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:03
 *@signature 我将追寻并获取我想要的答案
 */
class ConstantPool {

    private val cpInfos: MutableList<CPInfo> = mutableListOf()

    fun add(cpInfo: CPInfo) {
        cpInfos.add(cpInfo)
    }

    fun get(index: Int): CPInfo {
        return cpInfos[index]
    }


    companion object {
        const val CONSTANT_Class = 7
        const val CONSTANT_Fieldref = 9
        const val CONSTANT_Methodref = 10
        const val CONSTANT_InterfaceMethodref = 11
        const val CONSTANT_String = 8
        const val CONSTANT_Integer = 3
        const val CONSTANT_Float = 4
        const val CONSTANT_Long = 5
        const val CONSTANT_Double = 6
        const val CONSTANT_NameAndType = 12
        const val CONSTANT_Utf8 = 1
        const val CONSTANT_MethodHandle = 15
        const val CONSTANT_MethodType = 16
        const val CONSTANT_Dynamic = 17
        const val CONSTANT_InvokeDynamic = 18
        const val CONSTANT_Module = 19
        const val CONSTANT_Package = 20
    }


}

data class CPInfo(
    val tag: U1,
    val info: Info,
)

data class Info(
    val value: ByteArray
)