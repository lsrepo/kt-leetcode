class NumberOfIslands {
    private fun markVisited(grid: Array<CharArray>, row: Int, col: Int): Int {
        // edge cases
        if (row !in grid.indices || col !in grid[0].indices || grid[row][col] == '0'){
            return 0
        }
        grid[row][col] = '0'

        markVisited(grid, row+1, col)
        markVisited(grid, row-1, col)
        markVisited(grid, row, col+1)
        markVisited(grid, row, col-1)

        return 1
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var island = 0

        // loop through each element in-place
        for (row in grid.indices){
            // for each element, mark neighbours with same value visited
            for (col in grid[row].indices){
                island += markVisited(grid, row, col)
            }
        }
        return island
    }
}