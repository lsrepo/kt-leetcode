import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HammingDistanceTest {
    val s = HammingDistance()

    @Test
    fun hammingDistance() {
        assertEquals(2, s.hammingDistance(1, 4))
    }
}