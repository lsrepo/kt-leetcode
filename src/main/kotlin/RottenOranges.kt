import java.util.*

class RottenOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.indices
        val cols = grid[0].indices
        val q = ArrayDeque<Point>()
        val depth = Array (grid.size) {
            Array(grid[0].size) { 0 }
        }
        var n = 0

        // Collect all of the rotten ones
        for (row in rows){
            for (col in cols){
                if (grid[row][col] == 2){
                    q.add(Point(row, col))
                }
            }
        }

        while (q.isNotEmpty()){
            val p = q.poll()
            val neighbours = getValidNeighboursOf(1, grid, p.row, p.col)
            print("p: $ p")
            print("neighbours: $neighbours, ")
            neighbours.forEach{
                grid[it.row][it.col] = 2
                val d = depth[p.row][p.col] + 1
                depth[it.row][it.col] = d
                n = d
                println("d: $d")
            }
            q.addAll(neighbours)
        }

        for (row in rows){
            for (col in cols){
                if (grid[row][col] == 1){
                    return -1
                }
            }
        }

        return n
    }

    private fun getValidNeighboursOf(value: Int, grid: Array<IntArray>, row: Int, col: Int): List<Point> {
        return listOf(
            Point(row+1, col),
            Point(row-1, col),
            Point(row, col+1),
            Point(row, col-1)
        )
            .filter { it.row in grid.indices && it.col in grid[0].indices }
            .filter { grid[it.row][it.col] == value }
    }
}

data class Point(val row: Int, val col: Int)
