package _2015._1

import util.BaseTask

object B_1_2015 : BaseTask("2015_1") {
    override suspend fun runTask() = algorithm(input.readText())

    private fun algorithm(input: String): Int {
        var counter = 0
        input.mapIndexed { index, c ->
            when (c) {
                '(' -> counter++
                ')' -> counter--
            }

            if (counter < 0) return index + 1
        }

        return 0
    }

}