package _2015._1

import util.BaseTask


object A_1_2015 : BaseTask("2015_1") {
    override suspend fun runTask() = algorithm(input.readText())

    private fun algorithm(input: String) =
        input.sumBy { c ->
            when (c) {
                '(' -> 1
                ')' -> -1
                else -> 0
            }
        }

}

