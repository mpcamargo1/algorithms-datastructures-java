package Tree;

public class InvertTreeRecursive {

    private TreeNode root;

    private TreeNode invertTree(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode invertedNode = new TreeNode(node.val);

        invertedNode.left = invertTree(node.right);
        invertedNode.right = invertTree(node.left);

        return invertedNode;

    }

    public InvertTreeRecursive(TreeNode root) {
        this.root = root;
    }

    public TreeNode invertTree() {
        return invertTree(this.root);
    }


    public static void main(String[] args) {
        InvertTreeRecursive recursive = new InvertTreeRecursive(
                new TreeNode(3,
                        new TreeNode(4, new TreeNode(55), null),
                        new TreeNode(5, new TreeNode(2), null)));
        recursive.invertTree();

    }
}
