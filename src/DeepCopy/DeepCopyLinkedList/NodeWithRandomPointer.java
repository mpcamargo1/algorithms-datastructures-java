package DeepCopy.DeepCopyLinkedList;

public class NodeWithRandomPointer {

    int val;

    NodeWithRandomPointer next;

    NodeWithRandomPointer random;

    public NodeWithRandomPointer(int val) {
        this.val = val;
    }

    public NodeWithRandomPointer(int val, NodeWithRandomPointer next, NodeWithRandomPointer random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
