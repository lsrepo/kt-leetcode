import org.junit.Test
import kotlin.test.assertEquals

internal class IntegerToEnglishWordsTest {

    val s = IntegerToEnglishWords()

    @Test
    fun `1234567891`(){
        val expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

        assertEquals(expected , s.numberToWords(1234567891))
    }

    @Test
    fun `712013011`(){
        val expected = "Seven Hundred Twelve Million Thirteen Thousand Eleven"
        assertEquals(expected , s.numberToWords(712013011))
    }

    @Test
    fun `0`(){
        val expected = "Zero"
        assertEquals(expected , s.numberToWords(0))
    }
    @Test
    fun `25`(){
        val expected = "Twenty Five"
        assertEquals(expected , s.numberToWords(25))
    }

    @Test
    fun `2500`(){
        val expected = "Two Thousand Five Hundred"
        assertEquals(expected , s.numberToWords(2500))
    }

    @Test
    fun `200`(){
        val expected = "Two Hundred"
        assertEquals(expected , s.numberToWords(200))
    }


}
