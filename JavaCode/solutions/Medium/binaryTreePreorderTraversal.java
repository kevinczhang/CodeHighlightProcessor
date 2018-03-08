/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution

        // Recursive Solution
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> re = new ArrayList<Integer>();
            if (root == null) return re;
            re.add(root.val);
            re.addAll(preorderTraversal(root.left));
            re.addAll(preorderTraversal(root.right));
            return re;
        }

        // Iterative Solution
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
            return res;
        }

        // Morris Travasal
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            TreeNode cur = root, prev;
            while (cur != null) {
                if (cur.left == null) {
                    res.add(cur.val);
                    cur = cur.right;
                } else {
                    prev = cur.left;
                    while (prev.right != null && prev.right != cur)
                        prev = prev.right;

                    if (prev.right == null) {
                        // the only difference with inorder-traversal
                        res.add(cur.val);
                        prev.right = cur;
                        cur = cur.left;
                    } else {
                        prev.right = null;
                        cur = cur.right;
                    }
                }
            }
            return res;
        }
}