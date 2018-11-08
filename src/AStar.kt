import java.util.Comparator
import java.util.PriorityQueue


class AStar {

    companion object {
        @JvmStatic
        private val goalX = 8
        @JvmStatic
        private val goalY = 11

        private val costComparator = Comparator<Cell> { c1, c2 ->
            val distanceFromC1 = c1.cost + manhattanDistance(c1, Cell(goalX, goalY))
            val distanceFromC2 = c2.cost + manhattanDistance(c2, Cell(goalX, goalY))


            if (distanceFromC1 > distanceFromC2) return@Comparator 1

            if (distanceFromC2 > distanceFromC1) -1 else 0

        }

        private fun manhattanDistance(c1: Cell, c2: Cell): Int {

            return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y)
        }

        private val pq = PriorityQueue(costComparator)

        @JvmStatic
        fun getPathAStar(arr: Array<IntArray>, x: Int, y: Int, cost: Int): Cell? {

            // To pop from the queue use 'pq.remove();'
            // To push into the queue use 'pq.add(cell);'

            // Write your code here!
            pq.add(Cell(x, y, cost, null)) //Start cell

            while (!pq.isEmpty()) {
                val c = pq.remove()
                if (arr[c.x][c.y] == 9) return c
                arr[c.x][c.y] = 2
                //Add valid children
                if (isFree(c.x - 1, c.y, arr)) pq.add(Cell(c.x - 1, c.y, c.cost + 1, c))
                if (isFree(c.x + 1, c.y, arr)) pq.add(Cell(c.x + 1, c.y, c.cost + 1, c))
                if (isFree(c.x, c.y + 1, arr)) pq.add(Cell(c.x, c.y + 1, c.cost + 1, c))
                if (isFree(c.x, c.y - 1, arr)) pq.add(Cell(c.x, c.y - 1, c.cost + 1, c))

            }

            return null
        }

        private fun isFree(x: Int, y: Int, arr: Array<IntArray>): Boolean {

            return x >= 0 && x < arr.size && y >= 0 && y < arr[x].size && (arr[x][y] == 0 || arr[x][y] == 9)
        }

    }
}