// calculate total size of outermost directory
fun calcOuterDir(list: MutableList<MutableList<String>>): Int {
    var outerTotal = 0
    for (i in list.indices) {
        for (j in list[i].indices) {
            if (list[i][j].toIntOrNull() != null) {
                outerTotal += list[i][j].toInt()
            }
        }
    }
    return outerTotal
}

// calculate minimum size needed to be deleted
fun calcMinDelSize(list: MutableList<MutableList<String>>): Int {
    return calcOuterDir(list) - 40_000_000
}

// calculate number of directory needed to be handled / converted to file size
fun calcDirCount(list: MutableList<MutableList<String>>): Int {
    var count = 0
    for (i in list.indices) {
        for (j in list[i].indices) {
            if (list[i][j] == "dir") {
                count++
            }
        }
    }
    return count
}

// restate the values in the list from "dir" to actual size values of the dir
fun handleDirConversion(dir: MutableList<String>, list: MutableList<MutableList<String>>) {
    var count = calcDirCount(list)
    while (true) {
        for (i in list.size - 1 downTo 0) {
            loop@for (j in list[i].indices step 2) {
                if (list[i][j] == "dir") {
                    var newValue = 0
                    var k = 0
                    for (x in list.indices) {
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
}

// calculate the least minimum total size needed to be deleted
fun calcTotalDelSize(input: List<String>, dir: MutableList<String>, list: MutableList<MutableList<String>>): Int {
    val minDelSize = handleDirAndList(input, dir, list)
    var totalSum = 70_000_000
    for (i in list.indices) {
        var currSum = 0
        for (j in list[i].indices step 2) {
            currSum += list[i][j].toInt()
        }
        if (currSum in minDelSize until totalSum) {
            totalSum = currSum
        }
    }
    return totalSum
}

fun handleDirAndList(input: List<String>, dir: MutableList<String>, list: MutableList<MutableList<String>>): Int {
    var rawList = mutableListOf<String>()
    val dirRegex = Regex("\\$ cd ([a-z]+|/)")
    val listRegex = Regex("^([a-z]*\\d*) ([a-z][.a-z]*)$")
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
    val minDelSize = calcMinDelSize(list)
    handleDirConversion(dir, list)
    return minDelSize
}

fun main() {
    val input = readInput("Day07")
    val dir = mutableListOf<String>()
    val list = mutableListOf<MutableList<String>>()
    calcTotalDelSize(input, dir, list).println()
}



