/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * ArrayList<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    private UndirectedGraphNode cloneBFS(UndirectedGraphNode root) {
        if (root == null)
            return root;

        ArrayDeque<UndirectedGraphNode> que = new ArrayDeque<UndirectedGraphNode>();
        que.addLast(root);

        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode rootCopy = new UndirectedGraphNode(root.label);
        visited.put(root, rootCopy);

        // BFS
        while (!que.isEmpty()) {
            root = que.removeFirst();
            UndirectedGraphNode node = visited.get(root);
            for (UndirectedGraphNode nb : root.neighbors) {
                if (visited.containsKey(nb)) {
                    node.neighbors.add(visited.get(nb));
                } else {
                    UndirectedGraphNode n = new UndirectedGraphNode(nb.label);
                    node.neighbors.add(n);
                    visited.put(nb, n);
                    que.addLast(nb);
                }
            }
        }

        return rootCopy;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneBFS(node);
    }
}