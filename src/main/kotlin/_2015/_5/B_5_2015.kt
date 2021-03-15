package _2015._5

import kotlinx.coroutines.runBlocking
import util.BaseTask

fun main() = runBlocking {
    B_5_2015.execute()
}

object B_5_2015 : BaseTask("2015_5") {
    val a = "(..).*\\1".toRegex()
    val b = "(.).\\1".toRegex()

    override suspend fun runTask() = input.readLines().filter { isNice(it) }.size

    private fun isNice(line: String): Boolean = line.contains(a) && line.contains(b)
}