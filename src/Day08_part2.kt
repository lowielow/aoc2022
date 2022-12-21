class Tree2 {
    val list = mutableListOf<MutableList<String>>()
    private var highestScore: Int= 0
    private var currentScore: Int = 0
    private fun checkAll(i: Int, j: Int): Int = checkLeft(i, j) * checkRight(i, j) * checkTop(i, j) * checkBottom(i, j)

    private fun checkLeft(i: Int, j: Int): Int {
        var countLeft = 0
        for (n in j - 1 downTo 0) {
            if (list[i][n] < list[i][j]) {
                countLeft++
            } else {
                countLeft++
                break
            }
        }
        return countLeft
    }

    private fun checkRight(i: Int, j: Int): Int {
        var countRight = 0
        for (n in j + 1 until list[0].size) {
            if (list[i][n] < list[i][j]) {
                countRight++
            } else {
                countRight++
                break
            }
        }
        return countRight
    }

    private fun checkTop(i: Int, j: Int): Int {
        var countTop = 0
        for (n in i - 1 downTo 0) {
            if (list[n][j] < list[i][j]) {
                countTop++
            } else {
                countTop++
                break
            }
        }
        return countTop
    }

    private fun checkBottom(i: Int, j: Int): Int {
        var countBottom = 0
        for (n in i + 1 until list.size) {
            if (list[n][j] < list[i][j]) {
                countBottom++
            } else {
                countBottom++
                break
            }
        }
        return countBottom
    }

    fun handleScenicScore(): Int {
        for (i in list.indices) {
            for (j in list[i].indices) {
                if (i >= 1 && i <= list.size  - 2 && j >= 1 && j <= list[0].size - 2) {
                    currentScore = checkAll(i, j)
                    if (currentScore > highestScore) {
                        highestScore = currentScore
                    }
                }
            }
        }
        return highestScore
    }
}

fun main() {

    val tree = Tree2()
    val input: List<String> = readInput("Day08")

    for (str in input) {
        tree.list.add(str.map{ it.toString() }.toMutableList())
    }

    tree.handleScenicScore().println()
}