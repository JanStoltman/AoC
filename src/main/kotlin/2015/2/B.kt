package `2015`.`2`

import java.io.File

fun main() {
    check(algorithm(listOf("2x3x4")) == 34)
    check(algorithm(listOf("1x1x10")) == 14)

    val input = File("src/main/resources/2015_2").readLines()
    println(algorithm(input))
}

private fun algorithm(input: List<String>) =
    input.sumBy { line ->
        val (l, w, h) = line.split('x').map { it.toInt() }

        2 * minOf(l + h, h + w, w + l) + l * w * h
    }