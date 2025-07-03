package Tree;

public class MaxNumber {

    public MaxNumber(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getMaxNumber() {
        int maxLeft = getMaxNumberRecursive(root.left);
        int maxRight = getMaxNumberRecursive(root.right);

        return Math.max(maxLeft, maxRight);
    }

    private int getMaxNumberRecursive(TreeNode node) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        int maxLeft = getMaxNumberRecursive(node.left);
        int maxRight = getMaxNumberRecursive(node.right);

        return Math.max(node.val, Math.max(maxLeft, maxRight));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(75,
                new TreeNode(80, new TreeNode(10), null),
                new TreeNode(71, new TreeNode(5), null));

        MaxNumber maxNumber = new MaxNumber(treeNode);
        maxNumber.getMaxNumber();
    }
}
