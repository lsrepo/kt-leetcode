class FactorialTrailingZeroes {
    // Recursive
    // Good side: dont need to worry about integer overflow
//        fun trailingZeroes(n: Int): Int = when (n) {
//            0 -> 0
//            else -> n / 5 + trailingZeroes(n / 5)
//        }

    // Iteratively
    fun trailingZeroes(n: Int): Int {
        var i:Long = 1
        var total = 0
        while (i <= n){
            i *= 5
            total += (n / i).toInt()
        }
        return total
    }
}
