import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class MinesweeperTest {

    val s = Minesweeper()
    @Test
    fun `Click on empty square`() {
        val input = arrayOf(
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'M', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E')
        )
        val click = intArrayOf(3,0)
        val expected = arrayOf(
            charArrayOf('B', '1', 'E', '1', 'B'),
            charArrayOf('B', '1', 'M', '1', 'B'),
            charArrayOf('B', '1', '1', '1', 'B'),
            charArrayOf('B', 'B', 'B', 'B', 'B')
        )

        val output = s.updateBoard(input, click)
        output.forEach { println(it.contentToString()) }
        assertTrue(output.contentDeepEquals(expected))
    }

    @Test
    fun `Click on bomb`() {
        val input = arrayOf(
            charArrayOf('B', '1', 'E', '1', 'B'),
            charArrayOf('B', '1', 'M', '1', 'B'),
            charArrayOf('B', '1', '1', '1', 'B'),
            charArrayOf('B', 'B', 'B', 'B', 'B')
        )

        val click = intArrayOf(1,2)
        val expected = arrayOf(
            charArrayOf('B', '1', 'E', '1', 'B'),
            charArrayOf('B', '1', 'X', '1', 'B'),
            charArrayOf('B', '1', '1', '1', 'B'),
            charArrayOf('B', 'B', 'B', 'B', 'B')
        )

        val output = s.updateBoard(input, click)
        assertTrue(output.contentDeepEquals(expected))
    }
}