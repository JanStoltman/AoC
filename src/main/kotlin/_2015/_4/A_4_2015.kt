package _2015._4

import util.BaseTask
import util.ext.toHexString
import java.security.MessageDigest

object A_4_2015 : BaseTask() {
    private const val INPUT = "iwrupvqb"

    override suspend fun runTask(): Any {
        val md = MessageDigest.getInstance("MD5")
        var i = 0
        var res = ""

        while (res.startsWith("00000").not()) {
            i++
            res = md.digest("${INPUT}$i".toByteArray()).toHexString()
        }

        return i
    }
}