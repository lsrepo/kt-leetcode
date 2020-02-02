
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class ValidSudokuTest {
    val s = ValidSudoku()

    @Test
    fun `valid case 1`() {
        val input = arrayOf(
            "53..7....".toCharArray(),
            "6..195...".toCharArray(),
            ".98....6.".toCharArray(),
            "8...6...3".toCharArray(),
            "4..8.3..1".toCharArray(),
            "7...2...6".toCharArray(),
            ".6....28.".toCharArray(),
            "...419..5".toCharArray(),
            "....8..79".toCharArray()
        )

        assertTrue(s.isValidSudoku(input))
    }

    @Test
    fun `invalid case 1`() {
        val input = arrayOf(
            "83..7....".toCharArray(),
            "6..195...".toCharArray(),
            ".98....6.".toCharArray(),
            "8...6...3".toCharArray(),
            "4..8.3..1".toCharArray(),
            "7...2...6".toCharArray(),
            ".6....28.".toCharArray(),
            "...419..5".toCharArray(),
            "....8..79".toCharArray()
        )
        assertFalse(s.isValidSudoku(input))
    }
}