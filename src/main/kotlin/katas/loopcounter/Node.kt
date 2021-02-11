package katas.loopcounter

class Node(var nextNode: Node? = null) {
    companion object {
        fun createChain(tailLength: Int, loopSize: Int): Node {
            require(tailLength + loopSize > 0)
            val tailNodes = (1..tailLength).map { Node() }
            tailNodes.forEachIndexed { i, node ->
                if (node != tailNodes.last()) {
                    node.nextNode = tailNodes[i + 1]
                }
            }
            require(loopSize != 1)
            val loopNodes = (1..loopSize).map { Node() }
            loopNodes.forEachIndexed { i, node ->
                if (i == 0 && tailNodes.isNotEmpty()) {
                    tailNodes.last().nextNode = node
                }
                when (node) {
                    loopNodes.last() -> node.nextNode = loopNodes.first()
                    else -> node.nextNode = loopNodes[i + 1]
                }
            }
            return tailNodes.firstOrNull() ?: loopNodes.first()
        }
    }
}