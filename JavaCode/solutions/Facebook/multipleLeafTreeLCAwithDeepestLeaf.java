public class MultipleChildrenSolution {
    public TreeNodeMulti findLca(TreeNodeMulti root) {
        return helper(root).node;
    }

    private Result helper(TreeNodeMulti root) {
        if (root == null) {
            return new Result(null, 0);
        }
        int depth = 0;
        List<Result> next = new ArrayList<>();
        for (TreeNodeMulti child : root.children) {
            next.add(helper(child));
        }
        Result deepest = new Result(null, 0);
        Result deepest2 = new Result(null, 0);
        for (Result result : next) {
            if (result.depth >= deepest.depth) {
                deepest2.node = deepest.node;
                deepest2.depth = deepest.depth;
                deepest.node = result.node;
                deepest.depth = result.depth;
            }
        }
        depth = 1 + deepest.depth;
        if (deepest.depth == deepest2.depth) {
            return new Result(root, depth);
        }
        return new Result(deepest.node, depth);
    }

    class Result {
        TreeNodeMulti node;
        int depth;

        public Result(TreeNodeMulti node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    class TreeNodeMulti {
        public int val;
        public List<TreeNodeMulti> children;

        public TreeNodeMulti(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
}