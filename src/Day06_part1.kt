fun main() {

    fun part1(input: List<String>): Int {
        var j = 0
        for (str in input) {
            for (i in 0..str.length - 4) {
                val result = str.substring(i, i + 4).map { it }.toMutableList()
                if (result.distinct().size == 4) {
                    j = i + 4
                    break
                }
            }
        }
        return j
    }

    val input = readInput("Day06")
    part1(input).println()

}
