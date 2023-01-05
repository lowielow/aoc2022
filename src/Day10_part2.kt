fun main() {

    fun printAlphabet(list: MutableList<String>) {
        for (i in list.indices) {
            if ((i + 1) % 40 != 0) {
                print(list[i])
            } else {
                println(list[i])
            }
        }
    }

    fun handleInput(input: List<String>) {
        val list = mutableListOf<String>()
        var currPos = 0
        for (str in input) {
            when (str) {
                "noop" -> {
                    val pixel = if (list.size % 40 in currPos..currPos + 2) "#" else "."
                    list.add(pixel)
                }
                else -> {
                    val (_, num) = str.split(" ")
                    repeat(2) {
                        val pixel = if (list.size % 40 in currPos..currPos + 2) "#" else "."
                        list.add(pixel)
                    }
                    currPos += num.toInt()
                }
            }
        }
        printAlphabet(list)
    }

    val input = readInput("Day10")
    handleInput(input)
}



