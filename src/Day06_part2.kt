fun main() {

    fun part2(input: List<String>): Int {
        var j = 0
        for (str in input) {
            for (i in 0..str.length - 14) {
                val result = str.substring(i, i + 14).map { it }.toMutableList()
                if (result.distinct().size == 14) {
                    j = i + 14
                    break
                }
            }
        }
        return j
    }

    val input = readInput("Day06")
    part2(input).println()

}
