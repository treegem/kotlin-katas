package katas.loopcounter

class Node(var next: Node? = null) {
    companion object {
        fun createChain(tailLength: Int, loopSize: Int): Node {
            require(tailLength + loopSize > 0)
            val tailNodes = createTailNodes(tailLength)
            require(loopSize != 1)
            val loopNodes = createLoopNodesAndLinkToTailNodes(loopSize, tailNodes)
            return tailNodes.firstOrNull() ?: loopNodes.first()
        }

        private fun createLoopNodesAndLinkToTailNodes(loopSize: Int, tailNodes: List<Node>): List<Node> {
            val loopNodes = (1..loopSize).map { Node() }
            loopNodes.forEachIndexed { i, node ->
                if (i == 0 && tailNodes.isNotEmpty()) {
                    tailNodes.last().next = node
                }
                when (node) {
                    loopNodes.last() -> node.next = loopNodes.first()
                    else -> node.next = loopNodes[i + 1]
                }
            }
            return loopNodes
        }

        private fun createTailNodes(tailLength: Int): List<Node> {
            val tailNodes = (1..tailLength).map { Node() }
            tailNodes.forEachIndexed { i, node ->
                if (node != tailNodes.last()) {
                    node.next = tailNodes[i + 1]
                }
            }
            return tailNodes
        }
    }
}