import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {

        var tx = 0
        var ty = 0
        var hx = 0
        var hy = 0
        val list = mutableListOf(mutableListOf(0,0))

        for (str in input) {
            val (ch, n) = str.split(" ")
            for (i in 1..n.toInt()) {
                when (ch) {
                    "R" -> {
                        if (abs(hx + 1 - tx) == 2 && (abs(hy - ty) == 1 || abs(hy - ty) == 0)) {
                            tx = hx
                            ty = hy
                        }
                        hx++
                    }
                    "L" -> {
                        if (abs(hx - 1 - tx) == 2 && (abs(hy - ty) == 1 || abs(hy - ty) == 0)) {
                            tx = hx
                            ty = hy
                        }
                        hx--
                    }
                    "U" -> {
                        if (abs(hy + 1 - ty) == 2 && (abs(hx - tx) == 1 || abs(hx - tx) == 0)) {
                            tx = hx
                            ty = hy
                        }
                        hy++
                    }
                    "D" -> {
                        if (abs(hy - 1 - ty) == 2 && (abs(hx - tx) == 1 || abs(hx - tx) == 0)) {
                            tx = hx
                            ty = hy
                        }
                        hy--
                    }
                }
                list.add(mutableListOf(tx, ty))
            }
        }
        return list.distinct().size
    }

    val input = readInput("Day09")
    part1(input).println()

}