import java.util.*

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * Intuition
 * Translation:
 * Find the longest subarray with at most K zeros.
 *
 *
 * Explanation
 * For each A[j], try to find the longest subarray.
 * If A[i] ~ A[j] has zeros <= K, we continue to increment j.
 * If A[i] ~ A[j] has zeros > K, we increment i.
 *
 */

class MaxConsecutiveOnesIII {

    /**
     * use i,j keep the answer, thus K is needed to record the borrowed 0s
     * e.g. when k = 2, j-i needs to be 3 until the end in 001000000000
     */
    fun longestOnes(A: IntArray, K: Int): Int {
        var k = K
        var i = 0
        var j = 0

        while (j < A.size) {
            if (A[j] == 0) k--
            if (k < 0 && A[i++] == 0) k++
            /**
             * the above is the short way to write the below
             *     if (k < 0){
             *         if (A[i] ==0)
             *             k++
             *         i++
             *    }
             */
            j++
        }
        return j - i
    }

    fun longestOnes2(A: IntArray, K: Int): Int {
        // record the last count
        var accu = 0
        var max = 0
        var k = ArrayDeque<Int>()

        for (i in A.indices){
            // el =1
            if (A[i] == 1) {
                accu++
                max = maxOf(max, accu)
                continue
            }

            // el = 0
            when {
                K == 0 -> accu = 0
                k.size == K -> accu = i - k.poll()
                else -> accu++
            }
            k.add(i)
            max = maxOf(max, accu)
        }
        return max
    }
}