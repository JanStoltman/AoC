package _2015._6

import kotlinx.coroutines.runBlocking
import util.BaseTask

fun main() = runBlocking {
    B_6_2015.execute()
}

object B_6_2015 : BaseTask("2015_6") {
    val board = Array(1000) { Array(1000) { 0 } }

    override suspend fun runTask() {
        for (line in input.readLines()) {
            val coords = coords(line)
            println(coords)
            when {
                line.startsWith("turn on") -> {
                    mapBoard(coords) { it + 1 }
                }

                line.startsWith("turn off") -> {
                    mapBoard(coords) { (it - 1).coerceAtLeast(0) }
                }

                line.startsWith("toggle") -> {
                    mapBoard(coords) { it + 2 }
                }
            }
        }

        println(board.sumBy { it.sum() })
    }

    private fun mapBoard(coords: Pair<Pair<Int, Int>, Pair<Int, Int>>, op: (Int) -> Int) {
        //0...y
        // ...
        //x...
        for (x in (coords.first.first..coords.second.first)) {
            for (y in (coords.first.second..coords.second.second)) {
                board[x][y] = op(board[x][y])
            }
        }
    }

    private fun coords(line: String) =
        "\\d+,\\d+".toRegex().findAll(line)
            .take(2)
            .map { it.value }
            .map { it.split(",").map { it.toInt() }.let { it[0] to it[1] } }
            .toList()
            .let { it[0] to it[1] }
}