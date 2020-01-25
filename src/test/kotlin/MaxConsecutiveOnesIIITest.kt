import kotlin.test.Test
import kotlin.test.assertEquals

internal class MaxConsecutiveOnesIIITest {

    @Test
    fun `case 1 `() {
        val m = MaxConsecutiveOnesIII()
        val arr = intArrayOf(0,0,0)
        val k = 2
        val actual = m.longestOnes(arr , k)

        assertEquals(k, actual)
    }

    @Test
    fun `case 2 `() {
        val m = MaxConsecutiveOnesIII()
        val arr = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
        val k = 2
        val actual = m.longestOnes(arr , k)

        assertEquals(6, actual)
    }

    @Test
    fun `case 3 `() {
        val m = MaxConsecutiveOnesIII()
        val arr = intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1)
        val k = 3
        val actual = m.longestOnes(arr , k)

        assertEquals(10, actual)
    }

    @Test
    fun `case 4`() {
        val m = MaxConsecutiveOnesIII()
        val arr = intArrayOf(0)
        val k = 4
        val actual = m.longestOnes(arr , k)

        assertEquals(1, actual)
    }


    @Test
    fun `k = 0`() {
        val m = MaxConsecutiveOnesIII()
        val arr = intArrayOf(0,0,1,1,1,0,0)
        val k = 0
        val actual = m.longestOnes(arr , k)

        assertEquals(3, actual)
    }


}