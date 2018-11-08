import AStar.Companion.getPathAStar

fun main(args: Array<String>) {
    val arr = arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
            , intArrayOf(1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1)
            , intArrayOf(1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1)
            , intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1)
            , intArrayOf(1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1)
            , intArrayOf(1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1)
            , intArrayOf(1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1)
            , intArrayOf(1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1)
            , intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1)
            , intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))

    val endCell: Cell? = getPathAStar(arr, 1, 1, 0)
    if (endCell != null) {
        println("End cell is: $endCell")
        endCell.printPath()
    } else {
        println("No path found")
    }
}