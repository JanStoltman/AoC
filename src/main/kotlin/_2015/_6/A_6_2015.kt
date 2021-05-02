package _2015._6

import kotlinx.coroutines.runBlocking
import util.BaseTask

fun main() = runBlocking {
    A_6_2015.execute()
}

object A_6_2015 : BaseTask("2015_6") {
    val board = Array(1000) { Array(1000) { false } }

    override suspend fun runTask() {
        for (line in input.readLines()) {
            val coords = coords(line)
            println(coords)
            when {
                line.startsWith("turn on") -> {
                    mapBoard(coords) { true }
                }

                line.startsWith("turn off") -> {
                    mapBoard(coords) { false }
                }

                line.startsWith("toggle") -> {
                    mapBoard(coords) { !it }
                }
            }
        }

        println(board.sumBy { it.filter { it }.count() })
    }

    private fun mapBoard(coords: Pair<Pair<Int, Int>, Pair<Int, Int>>, op: (Boolean) -> Boolean) {
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