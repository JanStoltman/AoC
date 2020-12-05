package `2015`.`2`

import java.io.File

fun main() {
    check(algorithm(listOf("2x3x4")) == 58)
    check(algorithm(listOf("1x1x10")) == 43)

    val input = File("src/main/resources/2015_2").readLines()
    println(algorithm(input))
}

private fun algorithm(input: List<String>) =
    input.sumBy { line ->
        val (l, w, h) = line.split('x').map { it.toInt() }
        val wh = w * h
        val lw = l * w
        val hl = h * l

        2 * lw + 2 * wh + 2 * hl + minOf(lw, wh, hl)
    }