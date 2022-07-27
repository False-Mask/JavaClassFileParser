package org.example.bean

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  21:30
 *@signature 我将追寻并获取我想要的答案
 */
data class ClassFile(
    val magicNumber: U4, //魔数
    val minorVersion: U2,//次版本号
    val magorVersion: U2,//主版本号
    val constantPoolCount: U2,//常量池大小
    val cpInfo: ConstantPool,//常量池
    val accessFlag: U2,//访问修饰
    val thisClass: U2,//当前类
    val superClass: U2,//父类
    val interfaceCount: U2,//接口数目
    val interfaces: Interfaces,//接口
    val fieldCount: U2,//属性数目
    val fieldInfo: Fields,//属性
    val methodCount: U2,//方法数量
    val methods: Methods,//方法
    val attributeCount: U2,//属性总数
    val attributeInfo: Attributes,//属性表
)