fun main() {

    fun part2(input: List<String>): Int {
        val inputSize = input.size
        var count = 0
        for (i in 0 until inputSize) {
            val (a1, a2, b1, b2) = input[i].split(",", "-").map { it.toInt() }
            if (a1 <= b2 && a2 >= b1) {
                count++
            }
        }
        return count
    }

    val input = readInput("Day04")
    part2(input).println()

}
