package _2015._3

import util.BaseTask

object A_3_2015 : BaseTask("2015_3") {
    override suspend fun runTask() = algorithm(input.readText())

    private fun algorithm(input: String): Int {
        var current = 0 to 0
        val visited = mutableSetOf(current)

        for (c in input) {
            when (c) {
                '^' -> current = current.north()
                'v' -> current = current.south()
                '>' -> current = current.east()
                '<' -> current = current.west()
            }

            visited.add(current)
        }

        return visited.size
    }

    private fun Pair<Int, Int>.north() = first to second + 1
    private fun Pair<Int, Int>.south() = first to second - 1
    private fun Pair<Int, Int>.east() = first + 1 to second
    private fun Pair<Int, Int>.west() = first - 1 to second
}