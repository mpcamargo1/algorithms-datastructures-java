package DeepCopy.DeepCopyLinkedList;

import java.util.HashMap;

public class DeepCopy {

    private NodeWithRandomPointer root;

    private HashMap<NodeWithRandomPointer, NodeWithRandomPointer> map = new HashMap<>();

    public DeepCopy(NodeWithRandomPointer root) {
        this.root = root;
    }

    public NodeWithRandomPointer deepCopy() {

        if (root == null) {
            return null;
        }

        NodeWithRandomPointer aux = root;

        while (aux != null) {
            NodeWithRandomPointer currentNodeVisited = aux;
            NodeWithRandomPointer nextNodeVisited = aux.next;
            NodeWithRandomPointer randomNodeVisited = aux.random;

            NodeWithRandomPointer copiedNode = copyNode(currentNodeVisited);

            if (randomNodeVisited != null) {
                copiedNode.random = copyNode(randomNodeVisited);
            }

            if (nextNodeVisited != null) {
                copiedNode.next = copyNode(nextNodeVisited);
            }

            aux = nextNodeVisited;
        }

        return map.get(root);
    }

    private NodeWithRandomPointer copyNode(NodeWithRandomPointer node) {
        NodeWithRandomPointer copiedNode = null;

        if (!map.containsKey(node)) {
            copiedNode = new NodeWithRandomPointer(node.val);
            map.put(node, copiedNode);
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        NodeWithRandomPointer node1 = new NodeWithRandomPointer(1);
        NodeWithRandomPointer node2 = new NodeWithRandomPointer(2);
        NodeWithRandomPointer node3 = new NodeWithRandomPointer(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3; // random do node1 aponta para node3 (que vem depois)
        node2.random = node1; // random do node2 aponta para node1 (que já passou)
        node3.random = node2; // random do node3 aponta para node2 (que já passou)

        DeepCopy deepCopy = new DeepCopy(node1);

        NodeWithRandomPointer node = deepCopy.deepCopy();
    }
}
