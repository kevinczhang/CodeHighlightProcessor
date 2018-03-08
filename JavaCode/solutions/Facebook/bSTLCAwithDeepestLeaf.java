public class Solution {
    //Recursive way
    // 'Time complexity: O(n),
    // Space complexity: O(h), height of the tree'
    public TreeNode findLCARucrsive(TreeNode root) {
        Pair result = findLCA(root);
        return result.node;
    }

    private Pair findLCA(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        int depth = 0;
        Pair left = findLCA(root.left);
        Pair right = findLCA(root.right);
        depth = Math.max(left.depth, right.depth) + 1;
        if (left.depth == right.depth) {
            return new Pair(root, depth);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, depth);
        } else {
            return new Pair(right.node, depth);
        }
    }

    class Pair {
        public TreeNode node;
        public int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // Iterative Solution
    public TreeNode findLCAIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        Queue<TreeNode> level = new LinkedList<>();
        TreeNode left = null;
        TreeNode right = null;
        level.offer(root);
        while (!level.isEmpty()) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.poll();
                if (i == 0) {
                    left = node;
                }
                if (i == size - 1) {
                    right = node;
                }
                if (node.left != null) {
                    level.offer(node.left);
                    childToParent.put(node.left, node);
                }
                if (node.right != null) {
                    level.offer(node.right);
                    childToParent.put(node.right, node);
                }
            }
        }
        while (left != right) {
            left = childToParent.get(left);
            right = childToParent.get(right);
        }
        return left;
    }
}