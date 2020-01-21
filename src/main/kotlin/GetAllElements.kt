import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.

 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class GetAllElements {
    private fun traverseTree(node: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (node == null){
            return list
        }

        node.left.let { list.addAll(traverseTree(it)) }
        list.add(node.`val`)
        node.right.let { list.addAll(traverseTree(it)) }
        return list
    }
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val pq = PriorityQueue<Int>()

        pq.addAll(traverseTree(root1))
        pq.addAll(traverseTree(root2))

        return pq.toList()
    }
}

fun main() {
    val s = GetAllElements()
    val root1 = TreeNode(3)
    val root2 = TreeNode(5)

    val sorted = s.getAllElements(root1, root2)
}