fun handleSum(list: MutableList<Int>): Int {
    var totalSum = 0
    for (i in 0 until 220) {
        if ((i + 1) % 40 == 20) {
            totalSum += (i + 1) * list[i]
        }
    }
    return totalSum
}

fun handleInput(input: List<String>): Int {
    val list = mutableListOf(1)
    for (str in input) {
        if (str == "noop") {
            list.add(list[list.size - 1])
        } else {
            val (action, num) = str.split(" ")
            if (action == "addx") {
                list.add(list[list.size - 1])
                list.add(list[list.size - 1] + num.toInt())
            }
        }
    }
    return handleSum(list)
}

fun main() {
    val input = readInput("Day10")
    handleInput(input).println()
}



