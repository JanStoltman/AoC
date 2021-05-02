package _2015

import _2015._1.A_1_2015
import _2015._1.B_1_2015
import _2015._2.A_2_2015
import _2015._2.B_2_2015
import _2015._3.A_3_2015
import _2015._3.B_3_2015
import _2015._4.A_4_2015
import _2015._4.B_4_2015
import _2015._5.A_5_2015
import _2015._5.B_5_2015
import _2015._6.A_6_2015
import _2015._6.B_6_2015

fun main() {
    println("Hello!\nRunning tasks")

    val tasks = setOf(
        A_1_2015, B_1_2015, A_2_2015, B_2_2015, A_3_2015, B_3_2015, A_4_2015, B_4_2015, A_5_2015, B_5_2015,
        A_6_2015, B_6_2015
    )

    for (task in tasks) {
        task.execute()
    }

    println("Thanks! See ya!")
}