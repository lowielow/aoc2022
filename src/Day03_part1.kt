fun main() {

    fun part1(input: List<String>): Int {
        val list = mutableListOf<Int>()
        val inputSize = input.size
        for (i in 0 until inputSize) {
            val firstString = input[i].substring(0,input[i].length/2)
            val secondString = input[i].substring(input[i].length/2,input[i].length)
            for (j in firstString) {
                if (j in secondString) {
                    if (Regex("[a-z]").matches(j.toString())) {
                        list.add(j.code - 96)
                    } else if (Regex("[A-Z]").matches(j.toString())) {
                        list.add(j.code - 38)
                    }
                    break
                }
            }
        }
        return list.sum()
    }

    val input = readInput("Day03")
    part1(input).println()

}
