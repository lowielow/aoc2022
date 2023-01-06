fun main() {

    val input = readInput("Day11")
    val itemList = mutableListOf<MutableList<Int>>()
    val operationList = mutableListOf<MutableList<String>>()
    val testList = mutableListOf<Int>()
    val trueList = mutableListOf<Int>()
    val falseList = mutableListOf<Int>()

    fun countMonkey(input: List<String>): Int {
        var monkeyCount = 0
        for (str in input) if ("Monkey" in str) {
            monkeyCount++
        }
        return monkeyCount
    }

    fun printLevel(inspectList: MutableList<Int>): Int {
        val descList = inspectList.sortedDescending()
        return descList[0] * descList[1]
    }

    fun repeatInspection(input: List<String>): Int {
        val inspectList = MutableList(countMonkey(input)){ 0 }
        repeat (20) {
            for (monkeyNum in itemList.indices) {
                for (monkeyItem in itemList[monkeyNum].indices) {
                    val sign = operationList[monkeyNum][0]
                    val num = if (operationList[monkeyNum][1].toIntOrNull() != null) operationList[monkeyNum][1].toInt() else itemList[monkeyNum][monkeyItem]
                    val worryLevel = if (sign == "*") (itemList[monkeyNum][monkeyItem] * num) / 3 else (itemList[monkeyNum][monkeyItem] + num) / 3
                    if (worryLevel % testList[monkeyNum] == 0) itemList[trueList[monkeyNum]].add(worryLevel) else itemList[falseList[monkeyNum]].add(worryLevel)
                }
                while (itemList[monkeyNum].isNotEmpty()) {
                    itemList[monkeyNum].removeAt(0)
                    inspectList[monkeyNum]++
                }
            }
        }
        return printLevel(inspectList)
    }

    fun handleInput(input: List<String>): Int {
        for (str in input) {
            val string = str.trim()
            val regex1 = Regex("Starting items: (.+)")
            val regex2 = Regex("Operation: new = old (.+)")
            val regex3 = Regex("Test: divisible by (\\d+)")
            val regex4 = Regex("If true: throw to monkey (\\d+)")
            val regex5 = Regex("If false: throw to monkey (\\d+)")
            when {
                regex1.matches(string) -> {
                    val match = regex1.find(string)!!
                    itemList.add(match.groupValues[1].split(", ").map{ it.toInt() }.toMutableList())
                }
                regex2.matches(string) -> {
                    val match = regex2.find(string)!!
                    operationList.add(match.groupValues[1].split(" ").map{ it }.toMutableList())
                }
                regex3.matches(string) -> {
                    val match = regex3.find(string)!!
                    testList.add(match.groupValues[1].toInt())
                }
                regex4.matches(string) -> {
                    val match = regex4.find(string)!!
                    trueList.add(match.groupValues[1].toInt())
                }
                regex5.matches(string) -> {
                    val match = regex5.find(string)!!
                    falseList.add(match.groupValues[1].toInt())
                }
            }
        }
        return repeatInspection(input)
    }
    handleInput(input).println()
}