package org.example.tools

import org.example.bean.U1
import org.example.bean.U2
import org.example.bean.U4
import java.io.InputStream

fun InputStream.readU2(): U2 {
    val bytes = readNBytes(2)
    return U2(bytes)
}

fun InputStream.readU4(): U4 {
    val bytes = readNBytes(4)
    return U4(bytes)
}

fun InputStream.readU1(): U1 {
    val bytes = read()
    return U1(bytes.toByte())
}