package Tree;

import java.util.Stack;

public class BinaryTreeSearchIterator {

    private TreeNode root;

    private Stack<TreeNode> stack;

    public BinaryTreeSearchIterator(TreeNode node) {
        this.root = node;
        this.stack = new Stack<>();
        pushLeftNodes(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeftNodes(node.right);

        return node.val;
    }


    private void pushLeftNodes(TreeNode subRoot) {
        TreeNode node = subRoot;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        BinaryTreeSearchIterator iterator = new BinaryTreeSearchIterator(subRoot);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
