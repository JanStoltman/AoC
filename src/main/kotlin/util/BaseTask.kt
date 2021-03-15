package util

import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.system.measureTimeMillis

abstract class BaseTask(private val inputFileName: String = "", private val execThresholdMs: Long = 100) {

    private val _inputFile = lazy { File("src/main/resources/$inputFileName") }
    protected val input
        get() = _inputFile.value

    fun execute() = runBlocking {
        lateinit var res: Any
        val time = measureTimeMillis {
            res = runTask()
        }

        println(buildResText(time, res))
    }

    private fun buildResText(time: Long, res: Any) =
        "Task ${this::class.simpleName?.padStart(10, ' ')}" +
                " took ${time.toString().padStart(10, ' ')} ms." +
                " Work on making me faster!".takeIf { time >= execThresholdMs }.orEmpty() +
                " Res: $res"

    protected abstract suspend fun runTask(): Any
}