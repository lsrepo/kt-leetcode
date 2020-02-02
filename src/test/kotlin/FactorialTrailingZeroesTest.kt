import kotlin.test.Test
import kotlin.test.assertEquals

internal class FactorialTrailingZeroesTest {
    val s = FactorialTrailingZeroes()

    @Test
    fun `0`() {
        assertEquals(0, s.trailingZeroes(0))
    }

    @Test
    fun `3`() {
        assertEquals(0, s.trailingZeroes(3))
    }

    @Test
    fun `5`() {
        assertEquals(1, s.trailingZeroes(5))
    }

    @Test
    fun `15`() {
        assertEquals(3, s.trailingZeroes(15))
    }

    @Test
    fun `625`() {
        assertEquals(156, s.trailingZeroes(625))
    }

    @Test
    fun `1808548329`() {
        assertEquals(452137076, s.trailingZeroes(1808548329))
    }
}