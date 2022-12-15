fun main() {

    fun part1(input: List<String>): Int {
        val inputSize = input.size
        var count = 0
        for (i in 0 until inputSize) {
            val (a1, a2, b1, b2) = input[i].split(",", "-").map { it.toInt() }
            if (a1 <= b1 && a2 >= b2 || a1 >= b1 && a2 <= b2) {
                count++
            }
        }
        return count
    }

    val input = readInput("Day04")
    part1(input).println()

}
