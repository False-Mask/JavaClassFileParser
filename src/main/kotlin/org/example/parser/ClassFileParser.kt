package org.example.parser

import org.example.bean.*
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
        val cpInfo = readCpInfo()
        val accessFlag = input.readU2()
        val thisClass = input.readU2()
        val supperClass = input.readU2()
        val interfaceCount = input.readU2()
        val interfaces = readInterfaces(input)
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
        TODO()
    }

    private fun readMethods(input: InputStream): Methods {
        TODO()
    }

    private fun readFields(input: InputStream): Fields {
        TODO()
    }

    private fun readInterfaces(input: InputStream): Interfaces {
        TODO()
    }

    private fun readCpInfo(): ConstantPool {
        TODO()
    }
}