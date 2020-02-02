import java.lang.Integer.max
import java.lang.Integer.min

enum class State(val code: Int) {
    DEAD(0),
    LIVE(1),
    REBORN(3),
    DIED(4)
}

class GameOfLife {
    data class Point(val row: Int, val col: Int)

    private fun countAliveNeighbour(board: Array<IntArray>, p: Point): Int{
        val points: MutableList<Point> = mutableListOf()

        val (row, col) = p
        for (r in -1..1){
            for (c in -1..1){
                if (r == 0 && c == 0)
                    continue
                if (row + r in board.indices && col + c in board[0].indices){
                    points.add(Point(row + r, col + c))
                }
            }
        }
//        for (r in max(0, row - 1)..min(row + 1, board.size - 1)){
//            for (c in max(0, col - 1)..min(col + 1, board[0].size - 1)){
//                if (r == row && c == col)
//                    continue
//                points.add(Point(r, c))
//            }
//        }

        return points.count {
            board[it.row][it.col] == State.LIVE.code ||
            board[it.row][it.col] == State.DIED.code
        }
    }

    fun gameOfLife(board: Array<IntArray>): Unit {
        for (row in board.indices){
            for (col in board[0].indices){
                val aliveCount = countAliveNeighbour(board, Point(row, col))
                val currState = board[row][col]

                if (currState == State.LIVE.code){
                    when (aliveCount) {
                        // under-population
                        0, 1, in 4..8  -> board[row][col] = State.DIED.code
                    }
                } else if (currState == State.DEAD.code && aliveCount == 3) {
                    // over-population
                    board[row][col] = State.REBORN.code
                }
            }
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                val currState = board[row][col]
                when (currState) {
                    State.REBORN.code -> board[row][col] = State.LIVE.code
                    State.DIED.code -> board[row][col] = State.DEAD.code
                }
            }
        }
    }
}