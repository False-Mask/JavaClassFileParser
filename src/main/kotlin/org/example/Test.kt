package org.example

import org.example.parser.ClassFileParser
import java.io.File
import java.io.FileInputStream

/**
 *@author ZhiQiang Tu
 *@time 2022/7/27  23:03
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    val file = File("Test.class")
    val fileParser = ClassFileParser()
    val clasFile = fileParser.parse(FileInputStream(file))
    println(clasFile)
}