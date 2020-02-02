class HammingDistance {
    fun hammingDistance(x: Int, y: Int) = Integer.bitCount(x xor y)
}
