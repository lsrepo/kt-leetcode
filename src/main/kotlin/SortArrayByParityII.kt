class SortArrayByParityII {
    fun sortArrayByParityII(A: IntArray): IntArray {
        var odd = 1
        var even = 0
        val sorted = IntArray(A.size)

        for (i in A){
            if (i.rem(2) == 1){
                sorted[odd] = i
                odd += 2
            } else {
                sorted[even] = i
                even += 2
            }
        }
        return sorted
    }
}
