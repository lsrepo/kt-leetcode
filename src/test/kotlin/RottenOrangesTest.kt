import kotlin.test.Test
import kotlin.test.assertEquals

internal class RottenOrangesTest {

    @Test
    fun `test 1`() {
        val arr = arrayOf(
            intArrayOf(2,1,1),
            intArrayOf(1,1,0),
            intArrayOf(0,1,1)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(4, actual)
    }

    @Test
    fun `at least one will not rot`() {
        val arr = arrayOf(
            intArrayOf(2,1,1),
            intArrayOf(0,1,1),
            intArrayOf(1,0,1)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(-1, actual)
    }

    @Test
    fun `all empty`() {
        val arr = arrayOf(
            intArrayOf(0)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(0, actual)
    }

    @Test
    fun `one row`() {
        val arr = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(2)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(1, actual)
    }

    @Test
    fun `one fresh`() {
        val arr = arrayOf(
            intArrayOf(1)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(-1, actual)
    }

    @Test
    fun `one rotten`() {
        val arr = arrayOf(
            intArrayOf(2)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(0, actual)
    }

    @Test
    fun `one forever isolated`() {
        val arr = arrayOf(
            intArrayOf(2),
            intArrayOf(2),
            intArrayOf(1),
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(1)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(-1, actual)
    }

    @Test
    fun `case 2`() {
        val arr = arrayOf(
            intArrayOf(2,2),
            intArrayOf(1,1),
            intArrayOf(0,0),
            intArrayOf(2,0)
        )

        val r = RottenOranges()
        val actual = r.orangesRotting(arr)

        assertEquals(1, actual)
    }
}