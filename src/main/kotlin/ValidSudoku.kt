class ValidSudokuConcise {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()

        for (row in board.indices) {
            for (col in board[0].indices){
                val value = board[row][col]
                if (value == '.' )
                    continue
                if (
                    !set.add("$value in row $row") ||
                    !set.add("$value in col $col") ||
                    !set.add("$value in box ${row/3} - ${col/3}")
                ){
                    print(set.last())
                    return false
                }
            }
        }
        return true
    }
}

class ValidSudoku {
//class ValidSudokuIteratorApproach {
    data class Point(val row: Int, val col: Int)

    private fun isGroupValid(board: Array<CharArray>, iterator: RowIterator): Boolean {
//        val array = BooleanArray(9)
//        while (iterator.hasNext()){
//            val (row, col) = iterator.next()
//            val item = board[row][col]
//            if (item == '.'){
//                continue
//            }
//            if (array[item.minus('1')]){
//                return false
//            }
//            array[item.minus('1')] = true
//        }
        return iterator
            .asSequence()
            .toList()
            .map { (row,col) ->board[row][col] }
            .filter { it != '.'  }
            .run{ this.distinct().size == this.size }
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowIterators = ((0..8)).map { RowIterator(Point(it, 0), 9) }
        val colIterators = ((0..8)).map { RowIterator(Point( 0, it), 1) }
        val boxIterators: MutableList<RowIterator> = mutableListOf()

        for (r in 0..8 step 3){
            for (c in 0..8 step 3){
                boxIterators.add(RowIterator(Point(r, c), 3))
            }
        }
        val iterators = listOf(
            *rowIterators.toTypedArray(),
            *colIterators.toTypedArray(),
            *boxIterators.toTypedArray()
        )
        return iterators.all { isGroupValid(board, it) }
    }

    open class RowIterator(private val start: Point, private val itemPerRow: Int): Iterator<Point> {
        private var n = 0
        var row = start.row
        var col = start.col

        override fun hasNext(): Boolean {
            return n != 9
        }

        override fun next(): Point {
            if (col == start.col + itemPerRow){
                col = start.col
                row++
            }
            n++
            return Point(row, col++)
        }
    }
}
