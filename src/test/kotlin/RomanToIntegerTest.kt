import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RomanToIntegerTest {
    private val s = RomanToInteger()

    @CsvSource(
        "III, 3",
        "IV, 4",
        "IX, 9",
        "LVIII, 58",
        "MCMXCIV, 1994"
    )
    @ParameterizedTest
    fun tests(input: String, expected: Int ){
        assertEquals(expected, s.romanToInt(input), "$input -> $expected")
    }
}
