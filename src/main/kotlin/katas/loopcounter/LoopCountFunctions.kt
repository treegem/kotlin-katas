package katas.loopcounter

fun loopSize(n: Node): Int {
    val nodes = mutableListOf<Node>()
    var currentNode: Node? = n
    while (nodes.doesNotContain(currentNode)) {
        nodes.add(currentNode!!)
        currentNode = currentNode.next
        if (currentNode == null) return 0
    }
    return nodes.size - nodes.indexOf(currentNode)
}

fun <T> List<T>.doesNotContain(element: T) = !this.contains(element)