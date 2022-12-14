fun main() {

    fun part2(input: List<String>): Int {
        val listOne: MutableList<Int> = mutableListOf<Int>()
        var currentSum = 0
        val inputSize: Int = input.size
        for (i in 0 until inputSize) {
            if (input[i].isEmpty()) {
                listOne.add(currentSum)
                currentSum = 0
            } else {
                currentSum += input[i].toInt()
            }
        }
        val listTwo = listOne.sortedDescending()
        return listTwo[0] + listTwo[1] + listTwo[2]
    }

    val input = readInput("Day01")
    part2(input).println()

}
