public static class Node {
    private final T data;
    private final Set<Node> adjacent = new HashSet<Node>();

    public Set<Node> getAdjacent() {
        return adjacent;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    // returns if the node was added, false if already there
    public boolean addAdjacent(Node node) {
        return adjacent.add(node);
    }

    // returns true if any were added
    public boolean addAdjacents(Set<Node> nodes) {
        return adjacent.addAll(nodes);
    }
}

class Solution {
    public static boolean pathExistsBidirectional(Node a, Node b) {
        // BFS on both nodes at the same time
        Queue<Node> queueA = new Queue<Node>();
        Queue<Node> queueB = new Queue<Node>();
        Set<Node> visitedA = new HashSet<Node>();
        Set<Node> visitedB = new HashSet<Node>();

        visitedA.add(a);
        visitedB.add(b);
        queueA.add(a);
        queueB.add(b);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (pathExistsBidirectionalHelper(queueA, visitedA, visitedB)) {
                return true;
            }
            if (pathExistsBidirectionalHelper(queueB, visitedB, visitedA)) {
                return true;
            }
        }

        return false;
    }

    private static boolean pathExistsBidirectionalHelper(Queue<Node> queue, Set<Node> visitedFromThisSide, Set<Node> visitedFromThatSide) {
        if (!queue.isEmpty()) {
            Node next = queue.remove();
            for (Node adjacent : next.getAdjacent()) {
                if (visitedFromThatSide.contains(adjacent)) {
                    return true;
                } else if (visitedFromThisSide.add(adjacent)) {
                    queue.add(adjacent);
                }
            }
        }
        return false;
    }
}