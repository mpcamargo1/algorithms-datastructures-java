package Tree;

public class SubTree {

    private TreeNode node;

    public SubTree(TreeNode node) {
        this.node = node;
    }


    public boolean isSubTree(TreeNode subRoot) {
        return isSubTree(node, subRoot);
    }
    private boolean isSubTree(TreeNode node, TreeNode subRoot) {
        if (node == null) {
            return false;
        }

        if (node.val == subRoot.val && compareSubTree(node, subRoot)) {
            return true;
        }

        if (isSubTree(node.left, subRoot)) {
            return true;
        }

        return isSubTree(node.right, subRoot);
    }

    private boolean compareSubTree(TreeNode node, TreeNode node1) {
        if (node != null && node1 == null) {
            return false;
        }

        if (node == null && node1 != null) {
            return false;
        }

        if (node == null) {
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (node.val == node1.val) {
            left = compareSubTree(node.left, node1.left);
            right = compareSubTree(node.right, node1.right);
        }

        return left && right;
    }

    public static void main(String[] args) {
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        SubTree subTree = new SubTree(new TreeNode(3,
                new TreeNode(5),
                new TreeNode(4, subRoot, new TreeNode(2))));

        System.out.println(subTree.isSubTree(subRoot));

    }

}
