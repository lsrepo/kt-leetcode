import kotlin.math.pow

class IntegerToEnglishWords {
    private val to19 = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    private val tens = arrayOf("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    private val ks = arrayOf("Thousand", "Million", "Billion")

    private fun words(num: Int): Array<String> = when {
        num == 0 -> arrayOf()
        num < 20 -> arrayOf(to19[num - 1])
        num < 100 -> arrayOf(tens[(num / 10) - 2], *words(num.rem(10)))
        num < 1000 -> arrayOf(to19[num/100 - 1], "Hundred", *words(num.rem(100)))

        else -> {
            var arr = arrayOf<String>()
            for (i in ks.indices) {
                val upper = 1000.0.pow(i + 2)
                val divider = (upper / 1000).toInt()
                if (num < upper){
                    arr =  arrayOf(*words(num/divider), ks[i], *words(num.rem(divider)))
                    break
                }
            }
            arr
        }
    }

    fun numberToWords(num: Int): String {
        return if (num == 0)
            "Zero"
        else words(num)
            .filter { it.isNotBlank() }
            .joinToString(" ")
    }
}
