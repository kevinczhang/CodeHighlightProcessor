public class Solution {

    /**
     * Represents Node of the graph and contains the nodes that are attached to it. We may
     * also have ids but emitted as array index is being used as node id.
     */
    private static class Node<T> {
        private final List<Node<T>> childNodes = new ArrayList<>();

        private void addChildNode(Node<T> node) {
            this.childNodes.add(node);
        }
    }

    /**
     * Returns an array of integer containing below information about tree represented by input node:
     * 	- No of vertices
     * 	- Edges removed to decompose tree into trees of even vertices
     */
    private static int[] decomposeTree(Node<Integer> node) {

        int count = 0, edgesToRemove = 0;
        for(Node<Integer> childNode : node.childNodes) {
            // For each child node
            // calls current method recursively
            final int[] tmpMetadata = decomposeTree(childNode);
            // Accumulates edgesToRemove in a local variable
            edgesToRemove += tmpMetadata[1];
            // Checks if returned count is even - if yes, increments edgesToRemove by 1
            // otherwise adds returned count to this method's count
            if(tmpMetadata[0] % 2 == 0) {
                edgesToRemove++;
            } else {
                count += tmpMetadata[0];
            }
        }
        // Increments count since we are done with current node processing
        count++;
        //returns count for input node along with edges that can be removed to decompose the tree
        return new int[]{count, edgesToRemove};
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int M = in.nextInt();

        // Keeps all the nodes of tree in an array
        final Node<Integer>[] treeNodes = (Node<Integer>[]) new Node[N];
        for(int i = 0; i < M; i++) {
            // Gets first node of vertex
            final int node1 = in.nextInt() - 1;
            // Gets second node of vertex
            final int node2 = in.nextInt() - 1;

            // If nodes exist in array, reuses those else creates a new node and adds back to array
            treeNodes[node1] = (treeNodes[node1] == null ? new Node<Integer>() : treeNodes[node1]);
            treeNodes[node2] = (treeNodes[node2] == null ? new Node<Integer>() : treeNodes[node2]);

            //In order to create edge, we need to link nodes. Since this is a tree, it will be a directed edge and
            // for consistency, we will add bigger node to smaller nodes
            if(node1 < node2) {
                treeNodes[node1].addChildNode(treeNodes[node2]);
            } else {
                treeNodes[node2].addChildNode(treeNodes[node1]);
            }
        }

        // Since first element of array represents root of tree, we pass it to recursive method decompose tree
        final int[] metadata = decomposeTree(treeNodes[0]);

        // Print no of edges to be removed returned by above method invocation
        System.out.println(metadata[1]);

        in.close();
    }
}