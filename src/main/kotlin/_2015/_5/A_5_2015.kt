package _2015._5

import kotlinx.coroutines.runBlocking
import util.BaseTask

fun main() = runBlocking {
    A_5_2015.execute()
}

object A_5_2015 : BaseTask("2015_5") {
    private val c = "(ab)|(cd)|(pq)|(xy)".toRegex()
    private val b = "(.)\\1".toRegex()
    private val a = ".*[aeiou].*[aeiou].*[aeiou].*".toRegex()

    override suspend fun runTask() = input.readLines().filter { isNice(it) }.size

    private fun isNice(line: String): Boolean = line.contains(b) && line.matches(a) && line.contains(c).not()
}