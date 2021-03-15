package _2015._3

import util.BaseTask

object B_3_2015 : BaseTask("2015_3") {
    override suspend fun runTask() = algorithm(input.readText())

    private fun algorithm(input: String): Int {
        var santa = 0 to 0
        var robo = 0 to 0
        val visited = mutableSetOf(santa)
        var santasTurn = true

        for (c in input) {
            when (c) {
                '^' -> if (santasTurn) santa = santa.north() else robo = robo.north()
                'v' -> if (santasTurn) santa = santa.south() else robo = robo.south()
                '>' -> if (santasTurn) santa = santa.east() else robo = robo.east()
                '<' -> if (santasTurn) santa = santa.west() else robo = robo.west()
            }

            if (santasTurn) visited.add(santa) else visited.add(robo)
            santasTurn = santasTurn.not()
        }

        return visited.size
    }

    private fun Pair<Int, Int>.north() = first to second + 1
    private fun Pair<Int, Int>.south() = first to second - 1
    private fun Pair<Int, Int>.east() = first + 1 to second
    private fun Pair<Int, Int>.west() = first - 1 to second

}