import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class GameOfLifeTest {
    val s = GameOfLife()

    @Test
    fun case1() {
        val input = arrayOf(
            intArrayOf(0,1,0),
            intArrayOf(0,0,1),
            intArrayOf(1,1,1),
            intArrayOf(0,0,0)
        )

        val expected = arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(1,0,1),
            intArrayOf(0,1,1),
            intArrayOf(0,1,0)
        )

        s.gameOfLife(input)
        print(input)
        assert(input.contentDeepEquals(expected))
    }
}