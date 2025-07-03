package Tree;

import java.util.*;

public class InvertTreeIterative {

    int val;
    InvertTreeIterative left;
    InvertTreeIterative right;

    InvertTreeIterative() {

    }

    InvertTreeIterative(int val) {
        this.val = val;
    }

    InvertTreeIterative(int val, InvertTreeIterative left, InvertTreeIterative right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private class Pair {

        private InvertTreeIterative visitedNode;

        private InvertTreeIterative invertedNode;

        public Pair(InvertTreeIterative nodeVisited, InvertTreeIterative invertedNode) {
            this.visitedNode = nodeVisited;
            this.invertedNode = invertedNode;
        }

        public InvertTreeIterative getInvertedNode() {
            return invertedNode;
        }

        public InvertTreeIterative getVisitedNode() {
            return visitedNode;
        }
    }

    public InvertTreeIterative invertTree(InvertTreeIterative root) {
        if (root == null) {
            return null;
        }

        InvertTreeIterative invertedTree = new InvertTreeIterative();
        invertedTree.val = root.val;

        Queue<Pair> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(new Pair(root, invertedTree));

        while(!nodesToVisit.isEmpty()) {
            Pair pair = nodesToVisit.poll();

            InvertTreeIterative visitedNode = pair.visitedNode;
            InvertTreeIterative invertedNode = pair.invertedNode;

            if (visitedNode.left != null) {
                invertedNode.right = new InvertTreeIterative(visitedNode.left.val);
                nodesToVisit.add(new Pair(visitedNode.left, invertedNode.right));
            }

            if (visitedNode.right != null) {
                invertedNode.left = new InvertTreeIterative(visitedNode.right.val);

                nodesToVisit.add(new Pair(visitedNode.right, invertedNode.left));
            }

        }

        return invertedTree;

    }

    public static void main(String[] args) {
        InvertTreeIterative node = new InvertTreeIterative(5,
                new InvertTreeIterative(3, null, new InvertTreeIterative(7)),
                new InvertTreeIterative(2));

        InvertTreeIterative invertedNode = node.invertTree(node);
    }
}
