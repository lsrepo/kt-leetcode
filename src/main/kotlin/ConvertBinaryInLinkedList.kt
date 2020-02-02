class ConvertBinaryInLinkedList {
    fun getDecimalValue(head: ListNode?): Int {
        var ans = 0
        var h = head
        while (h != null) {
            ans = ans shl 1 or h.`val`
            h = h.next
        }
        return ans
    }
}

fun main(){


    val a = -128
    println(a.toUInt().toString(2))
}