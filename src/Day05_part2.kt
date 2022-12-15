class Stack2 {

    val input = readInput("Day05")
    private val rawList = mutableListOf<MutableList<Char>>()
    private val newList = mutableListOf<MutableList<Char>>()

    fun addStack(str: String) {
        var raw = ""
        for (i in 1 until str.length step 4) {
            raw += str[i].toString()
        }
        rawList.add(raw.toMutableList())
    }

    fun arrangeStack() {
        for (j in 0 until rawList[0].size) {
            var new = ""
            for (i in 0 until rawList.size) {
                if (rawList[i][j] == ' ') {
                    continue
                } else {
                    new = rawList[i][j] + new
                }
            }
            newList.add(new.toMutableList())
        }
    }

    fun handleMove(regex: Regex, str: String) {
        val match = regex.find(str)!!
        val (a, b, c) = match.destructured
        when (a.toInt()) {
            1 -> repeat(a.toInt()) {newList[c.toInt() - 1].add(newList[b.toInt() - 1][newList[b.toInt() - 1].size - 1]) }
            else -> newList[c.toInt() - 1].addAll(newList[b.toInt() - 1].takeLast(a.toInt()))
        }
        repeat(a.toInt()) {newList[b.toInt() - 1].removeAt(newList[b.toInt() - 1].size - 1)}
    }

    fun printTopStack(): String {
        var str = ""
        for (i in newList.indices) {
            str += newList[i][newList[i].size - 1].toString()
        }
        return str
    }

}

fun main() {

    val stack = Stack2()
    val regexStack = Regex(".*[A-Z].*")
    val regexMove = Regex("\\D*(\\d+)\\D*(\\d)\\D*(\\d)")

    fun part2(input: List<String>): String {
        for (i in input.indices) {
            if (regexStack.matches(input[i])) {
                stack.addStack(input[i])
            } else if (input[i].isEmpty()) {
                stack.arrangeStack()
            } else if (regexMove.matches(input[i])) {
                stack.handleMove(regexMove, input[i])
            }
        }
        return stack.printTopStack()
    }

    part2(stack.input).println()

}
