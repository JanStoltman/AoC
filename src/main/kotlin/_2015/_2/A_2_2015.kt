package _2015._2

import util.BaseTask

object A_2_2015 : BaseTask("2015_2") {
    override suspend fun runTask() = algorithm(input.readLines())

    private fun algorithm(input: List<String>) =
        input.sumBy { line ->
            val (l, w, h) = line.split('x').map { it.toInt() }
            val wh = w * h
            val lw = l * w
            val hl = h * l

            2 * lw + 2 * wh + 2 * hl + minOf(lw, wh, hl)
        }
}