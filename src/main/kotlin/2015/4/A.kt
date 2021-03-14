package `2015`.`4`

import java.math.BigInteger
import java.security.MessageDigest

private const val INPUT = "iwrupvqb"

fun main() {
    val md = MessageDigest.getInstance("MD5")
    var i = 0
    var res = ""

    while (res.startsWith("00000").not()) {
        i++
        res = BigInteger(1, md.digest("$INPUT$i".toByteArray())).toString(16).padStart(32, '0')
    }

    println("$res     $i")
}