package Tree;

public class MinDepth {

    public MinDepth(TreeNode root) {
        this.root = root;
    }

    private final TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public int getMinDepth(){
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left == null) {
            return 1 + getMinDepth(node.right);
        }

        if (node.right == null) {
            return 1 + getMinDepth(node.left);
        }

        int depthLeft = getMinDepth(node.left);
        int depthRight = getMinDepth(node.right);

        return 1 + Math.min(depthLeft, depthRight);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(75,
                new TreeNode(80, new TreeNode(10, new TreeNode(7), new TreeNode(5)), null),
                new TreeNode(71, new TreeNode(5), null));

        MinDepth minDepth = new MinDepth(treeNode);
        System.out.println(minDepth.getMinDepth());
    }
}
