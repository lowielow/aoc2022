fun main() {

    fun part2(input: List<String>): Int {
        val inputSize: Int = input.size
        var totalScore = 0
        for (i in 0 until inputSize) {
            totalScore += when (input[i]) {
                "A X" -> 3
                "A Y" -> 4
                "A Z" -> 8
                "B X" -> 1
                "B Y" -> 5
                "B Z" -> 9
                "C X" -> 2
                "C Y" -> 6
                "C Z" -> 7
                else -> 0
            }
        }
        return totalScore
    }

    val input = readInput("Day02")
    part2(input).println()

}
