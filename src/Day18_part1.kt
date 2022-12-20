fun main() {

    fun part1(input: List<String>): Int {
        val list = mutableListOf<MutableList<String>>()
        for (str in input) {
            list.add(str.split(",").map { it }.toMutableList())
        }
        var totalSides = list.size * 6
        for (i in list.indices) {
            val x = list[i][0]
            val y = list[i][1]
            val z = list[i][2]
            if (x.toInt() - 1 >= 0 && "${x.toInt() - 1},$y,$z" in input) {
                totalSides -= 1
            }
            if ("${x.toInt() + 1},$y,$z" in input) {
                totalSides -= 1
            }
            if (y.toInt() - 1 >= 0 && "$x,${y.toInt() - 1},$z" in input) {
                totalSides -= 1
            }
            if ("$x,${y.toInt() + 1},$z" in input) {
                totalSides -= 1
            }
            if (z.toInt() - 1 >= 0 && "$x,$y,${z.toInt() - 1}" in input) {
                totalSides -= 1
            }
            if ("$x,$y,${z.toInt() + 1}" in input) {
                totalSides -= 1
            }
        }
        return totalSides
    }

    val input = readInput("Day18")
    part1(input).println()

}