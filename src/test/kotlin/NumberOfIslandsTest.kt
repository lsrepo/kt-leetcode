package test

import NumberOfIslands
import kotlin.test.Test
import kotlin.test.assertEquals

internal class NumberOfIslandsTest {

    @Test
    fun `numIslands test 1`() {
        val s = NumberOfIslands()

        val input = """
            11110
            11010
            11000
            00000
        """
            .trimIndent()
            .lines()
            .map { it.toCharArray() }
            .toTypedArray()

        assertEquals(1, s.numIslands(input))
    }

    @Test
    fun `numIslands test 2`() {
        val s = NumberOfIslands()

        val input = """
            11000
            11000
            00100
            00011
        """
            .trimIndent()
            .lines()
            .map { it.toCharArray() }
            .toTypedArray()

        assertEquals(3, s.numIslands(input))
    }
}