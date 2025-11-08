package Tree;

import com.sun.source.tree.Tree;

import java.util.Optional;
import java.util.function.Function;

public class MergeBinaryTree {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(75,
                new TreeNode(80, new TreeNode(10), null),
                new TreeNode(71, new TreeNode(5), null));

        TreeNode root2 = new TreeNode(75,
                new TreeNode(80, null, new TreeNode(10)),
                new TreeNode(71, new TreeNode(5), null));

        new MergeBinaryTree().mergeTrees(root1, root2);
    }


    private TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode sumNode = new TreeNode(root1.val + root2.val);

        sumNode.left = mergeTrees(root1.left, root2.left);
        sumNode.right = mergeTrees(root1.right, root2.right);

        return sumNode;
    }
}
