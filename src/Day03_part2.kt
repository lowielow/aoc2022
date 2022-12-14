fun main() {

    fun part2(input: List<String>): Int {
        val list = mutableListOf<Int>()
        val inputSize = input.size
        for (i in 0..inputSize - 3 step 3) {
            for (ch in input[i]) {
                if (ch in input[i + 1] && ch in input[i + 2]) {
                    if (Regex("[a-z]").matches(ch.toString())) {
                        list.add(ch.code - 96)
                    } else if (Regex("[A-Z]").matches(ch.toString())) {
                        list.add(ch.code - 38)
                    }
                    break
                }
            }
        }
        return list.sum()
    }

    val input = readInput("Day03")
    part2(input).println()

}
