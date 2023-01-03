fun main() {

    fun part1(input: List<String>): Int {

        val dir = mutableListOf<String>()
        val list = mutableListOf<MutableList<String>>()
        var rawList = mutableListOf<String>()
        val dirRegex = Regex("\\$ cd ([a-z]+|/)")
        val listRegex = Regex("^([a-z]*\\d*) ([a-z][.a-z]*)$")
        var totalSum = 0
        var count = 0

        for (str in input) {
            if (dirRegex.matches(str)) {
                if (rawList.isNotEmpty()) {
                    list.add(rawList)
                    rawList = mutableListOf()
                }
                val dirMatch = dirRegex.find(str)!!
                dir.add(dirMatch.groupValues[1])
            } else if (listRegex.matches(str)) {
                val listMatch = listRegex.find(str)!!
                rawList.add(listMatch.groupValues[1])
                rawList.add(listMatch.groupValues[2])
            }
        }
        list.add(rawList)

        for (i in list.indices) {
            for (j in list[i].indices) {
                if (list[i][j] == "dir") {
                    count++
                }
            }
        }

        while (true) {
            for (i in list.size - 1 downTo 0) {
                loop@for (j in list[i].indices step 2) {
                    if (list[i][j] == "dir") {
                        var newValue = 0
                        var k = 0
                        for (x in dir.indices) {
                            if (x > i && list[i][j + 1] == dir[x]) {
                                k = x
                                break
                            }
                        }
                        for (l in list[k].indices step 2) {
                            if (list[k][l].toIntOrNull() != null) {
                                newValue += list[k][l].toInt()
                            }
                        }
                        list[i][j] = newValue.toString()
                        count--
                    }
                }
            }
            if (count == 0) {
                break
            }
        }

        for (i in list.indices) {
            var currSum = 0
            for (j in list[i].indices step 2) {
                currSum += list[i][j].toInt()
            }
            if (currSum <= 100000) {
                totalSum += currSum
            }
        }
        return totalSum

    }

    val input = readInput("Day07")
    part1(input).println()

}