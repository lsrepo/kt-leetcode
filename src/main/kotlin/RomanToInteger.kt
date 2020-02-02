class RomanToInteger {
    private val romanToIntegerMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var sum = 0
        for (i in 0..s.length-2){
           val curr = romanToIntegerMap.getValue(s[i])
           val next = romanToIntegerMap.getValue(s[i + 1])

           if (curr < next) sum -= curr
               else sum += curr
        }
        sum += romanToIntegerMap.getValue(s.last())
        return sum
    }
}