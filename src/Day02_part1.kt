fun main() {

    fun part1(input: List<String>): Int {
        val inputSize: Int = input.size
        var totalScore = 0
        for (i in 0 until inputSize) {
            totalScore += when (input[i]) {
                "A X" -> 4
                "A Y" -> 8
                "A Z" -> 3
                "B X" -> 1
                "B Y" -> 5
                "B Z" -> 9
                "C X" -> 7
                "C Y" -> 2
                "C Z" -> 6
                else -> 0
            }
        }
        return totalScore
    }

    val input = readInput("Day02")
    part1(input).println()

}
