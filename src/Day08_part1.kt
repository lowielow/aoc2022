class Tree {
    val list = mutableListOf<MutableList<String>>()
    var visibleCount: Int= 0

    private fun checkAll(i: Int, j: Int): Boolean = checkLeft(i, j) || checkRight(i, j) || checkTop(i, j) || checkBottom(i, j)

    private fun checkLeft(i: Int, j: Int): Boolean {
        for (n in 0 until j) {
            if (list[i][n] < list[i][j]) {
                continue
            } else {
                return false
            }
        }
        return true
    }

    private fun checkRight(i: Int, j: Int): Boolean {
        for (n in j + 1 until list[0].size) {
            if (list[i][n] < list[i][j]) {
                continue
            } else {
                return false
            }
        }
        return true
    }

    private fun checkTop(i: Int, j: Int): Boolean {
        for (n in 0 until i) {
            if (list[n][j] < list[i][j]) {
                continue
            } else {
                return false
            }
        }
        return true
    }

    private fun checkBottom(i: Int, j: Int): Boolean {
        for (n in i + 1 until list.size) {
            if (list[n][j] < list[i][j]) {
                continue
            } else {
                return false
            }
        }
        return true
    }

    fun handleVisibleCount(): Int {
        for (i in list.indices) {
            for (j in list[i].indices) {
                if (i >= 1 && i <= list.size  - 2 && j >= 1 && j <= list[0].size - 2) {
                    if (checkAll(i, j)) {
                        visibleCount++
                    }
                }
            }
        }
        return visibleCount
    }
}

fun main() {

    val tree = Tree()
    val input: List<String> = readInput("Day08")

    for (str in input) {
        tree.list.add(str.map{ it.toString() }.toMutableList())
    }

    tree.visibleCount = (tree.list.size - 1) * 4
    tree.handleVisibleCount().println()
}