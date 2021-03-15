package _2015._4

import util.BaseTask
import java.math.BigInteger
import java.security.MessageDigest

object B_4_2015 : BaseTask() {
    private const val INPUT = "iwrupvqb"

    override suspend fun runTask(): Any {
        val md = MessageDigest.getInstance("MD5")
        var i = 0
        var res = ""

        while (res.startsWith("000000").not()) {
            i++
            res = BigInteger(1, md.digest("$INPUT$i".toByteArray())).toString(16).padStart(32, '0')
        }

        return res
    }
}