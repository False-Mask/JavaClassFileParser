package org.example.parser

import org.example.bean.*
import org.example.bean.ConstantPool.Companion.CONSTANT_Class
import org.example.bean.ConstantPool.Companion.CONSTANT_Double
import org.example.bean.ConstantPool.Companion.CONSTANT_Dynamic
import org.example.bean.ConstantPool.Companion.CONSTANT_Fieldref
import org.example.bean.ConstantPool.Companion.CONSTANT_Float
import org.example.bean.ConstantPool.Companion.CONSTANT_Integer
import org.example.bean.ConstantPool.Companion.CONSTANT_InterfaceMethodref
import org.example.bean.ConstantPool.Companion.CONSTANT_InvokeDynamic
import org.example.bean.ConstantPool.Companion.CONSTANT_Long
import org.example.bean.ConstantPool.Companion.CONSTANT_MethodHandle
import org.example.bean.ConstantPool.Companion.CONSTANT_MethodType
import org.example.bean.ConstantPool.Companion.CONSTANT_Methodref
import org.example.bean.ConstantPool.Companion.CONSTANT_Module
import org.example.bean.ConstantPool.Companion.CONSTANT_NameAndType
import org.example.bean.ConstantPool.Companion.CONSTANT_Package
import org.example.bean.ConstantPool.Companion.CONSTANT_String
import org.example.bean.ConstantPool.Companion.CONSTANT_Utf8
import org.example.tools.readU1
import org.example.tools.readU2
import org.example.tools.readU4
import java.io.InputStream

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  22:33
 *@signature 我将追寻并获取我想要的答案
 */
class ClassFileParser {

    fun parse(input: InputStream): ClassFile {
        val magicNumber = input.readU4()
        val minorVersion = input.readU2()
        val magorVersion = input.readU2()
        val constantPoolSize = input.readU2()
        val cpInfo = readCpInfo(constantPoolSize.value(), input)
        val accessFlag = input.readU2()
        val thisClass = input.readU2()
        val supperClass = input.readU2()
        val interfaceCount = input.readU2()
        val interfaces = readInterfaces(interfaceCount.value(), input)
        val fieldCount = input.readU2()
        val fieldInfo = readFields(input)
        val methodCount = input.readU2()
        val methods = readMethods(input)
        val attributeCount = input.readU2()
        val attributes = readAttributes(input)
        return ClassFile(
            magicNumber,
            minorVersion,
            magorVersion,
            constantPoolSize,
            cpInfo,
            accessFlag,
            thisClass,
            supperClass,
            interfaceCount,
            interfaces,
            fieldCount,
            fieldInfo,
            methodCount,
            methods,
            attributeCount,
            attributes
        )
    }

    private fun readAttributes(input: InputStream): Attributes {
        return Attributes()
    }

    private fun readMethods(input: InputStream): Methods {
        return Methods()
    }

    private fun readFields(input: InputStream): Fields {
        return Fields()
    }

    private fun readInterfaces(interfaceCount: Int, input: InputStream): Interfaces {
        val interfaces = Interfaces()
        for (i in 0 until interfaceCount) {
            interfaces.add(input.readU2())
        }
        return interfaces
    }

    /**
     * @cpCount 常量池大小
     * @input 文件流
     */
    private fun readCpInfo(cpCount: Int, input: InputStream): ConstantPool {
        val cp = ConstantPool()
        for (i in 1 until cpCount) {
            val tag = input.readU1()
            val tagV = tag.value()
            val cpInfo = when (tagV) {
                CONSTANT_Class, CONSTANT_String, CONSTANT_MethodType,
                CONSTANT_Module, CONSTANT_Package -> {
                    CPInfo(tag, Info(input.readNBytes(2)))
                }

                CONSTANT_Methodref, CONSTANT_Fieldref, CONSTANT_InterfaceMethodref,
                CONSTANT_Integer, CONSTANT_Float, CONSTANT_NameAndType,
                CONSTANT_Dynamic, CONSTANT_InvokeDynamic -> {
                    CPInfo(tag, Info(input.readNBytes(4)))
                }

                CONSTANT_Long, CONSTANT_Double -> {
                    CPInfo(tag, Info(input.readNBytes(8)))
                }

                CONSTANT_Utf8 -> {
                    val len = input.readU2()
                    CPInfo(tag, Info(input.readNBytes(len.value())))
                }

                CONSTANT_MethodHandle -> {
                    CPInfo(tag, Info(input.readNBytes(3)))
                }

                else -> {
                    println(i)
                    throw IllegalStateException("unexpected tag")
                }
            }
            cp.add(cpInfo)

        }
        return cp
    }
}