import kotlin.math.pow

fun main() {

    fun convertDecimal(result: Long): String {
        val stringList = mutableListOf<String>()
        var decimal = result
        while (decimal != 0L) {
            val quotient = if (decimal % 5 > 2) decimal / 5 + 1 else decimal / 5
            val remainder = if (decimal % 5 == 3L) "=" else if (decimal % 5 == 4L) "-" else (decimal % 5).toString()
            decimal = quotient
            stringList.add(0, remainder)
        }
        return stringList.joinToString("")
    }

    fun handleInput(input: List<String>): String {
        var result: Long = 0
        for (string in input) {
            val s = string.length - 1
            for (i in string.indices) {
                val num = if (string[i] == '=') -2 else if (string[i] == '-') -1 else string[i].toString().toInt()
                result += (num * 5.toDouble().pow((s - i).toDouble())).toLong()
            }
        }
        return convertDecimal(result)
    }

    val input = readInput("Day25")
    handleInput(input).println()

}