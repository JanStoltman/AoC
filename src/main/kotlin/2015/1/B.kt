package `2015`.`1`

import java.io.File

/**
Now, given the same instructions, find the position of the first character that causes him to enter the
basement (floor -1). The first character in the instructions has position 1, the second character has position 2,
and so on.

For example:

) causes him to enter the basement at character position 1.
()()) causes him to enter the basement at character position 5.
What is the position of the character that causes Santa to first enter the basement?
 **/

fun main() {
    check(algorithm(")") == 1)
    check(algorithm("()())") == 5)


    val input = File("src/main/resources/2015_1").readText()
    println(algorithm(input))
}

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
