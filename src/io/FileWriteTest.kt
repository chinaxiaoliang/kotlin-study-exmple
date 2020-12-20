package io

import java.io.*


/*项目名: kotlin-study-example
*文件名: FileWriteTest
*创建者: 小亮
*创建时间:2020/12/20 10:36 下午
*描述: kotlin io操作
*/
fun main() {
    //写入文件
    writeTextToFile()
    //读取操作
    readFile()
}

fun readFile() {

    //读取字符
    val fileName = "src/io/" + "newWriterFile"
    FileReader(fileName).use {
        //将内容打印出来
        println(it.readText())
        //将每行的内容放入list集合中
        println(it.readLines())
    }
    //图片使用
    val fileNamePng = "src/io/" + "test.png"
    //读取文件
    FileInputStream(fileNamePng).use {file ->
        //将文件写入缓存流  更高效
        BufferedInputStream(file, 1024).use {
            FileOutputStream( "src/io/"  + "newPhoto.png").use {fot ->
                //读取的图片写入新文件中
                fot.write(it.readBytes())
            }
        }
    }
}

private fun writeTextToFile() {
    //[use] help auto close file
    val fileName = "src/io/" + "newWriterFile"
    FileWriter(fileName).use {
        //写入文件 不能追加
//        it.write("start writer content")
        //追加写入
//        it.append("start write content one\n")
//        it.append("start write content too")
        //自动帮你换行  不需要\n 辅助
        it.appendln("start write content one")
        it.appendln("start write content too")
    }

}
