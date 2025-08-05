package Tree;

public class PostOrderTraversal {

    private TreeNode root;

    public PostOrderTraversal(TreeNode node) {
        this.root = node;
    }

    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversalRecursive(node.left);
        postOrderTraversalRecursive(node.right);

        System.out.println(node.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(75,
                new TreeNode(80, new TreeNode(10), null),
                new TreeNode(71, new TreeNode(5), null));

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal(treeNode);

        postOrderTraversal.postOrderTraversal();
    }
}
