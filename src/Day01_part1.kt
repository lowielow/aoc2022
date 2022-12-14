fun main() {

    fun part1(input: List<String>): Int {
        var largestSum = 0
        var currentSum = 0
        val inputSize: Int = input.size
        for (i in 0 until inputSize) {
            if (input[i].isEmpty()) {
                if (currentSum > largestSum) {
                    largestSum = currentSum
                }
                currentSum = 0
            } else {
                currentSum += input[i].toInt()
            }
        }
        return largestSum
    }

    val input = readInput("Day01")
    part1(input).println()

}
