package _2015._2

import util.BaseTask

object B_2_2015 : BaseTask("2015_2") {
    override suspend fun runTask() = algorithm(input.readLines())

    private fun algorithm(input: List<String>) =
        input.sumBy { line ->
            val (l, w, h) = line.split('x').map { it.toInt() }

            2 * minOf(l + h, h + w, w + l) + l * w * h
        }
}