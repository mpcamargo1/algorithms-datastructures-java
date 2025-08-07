package DesignHashMap;

public class DesignHashMap {

    Node[] values;

    public DesignHashMap() {
        int MAX_SIZE = 16384;
        this.values = new Node[MAX_SIZE];
    }

    public void put(int key, int value) {
        if (key < 0) {
            throw new IllegalArgumentException("Invalid key");
        }

        int index = getIndex(key);
        Node search = values[index];

        if (search == null) {

            values[index] = new Node(-1,-1, new Node(key, value, null));

            return;
        }

        Node previous = search;
        Node current = search.getNext();
        while (current != null) {
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }

            previous = current;
            current = current.getNext();
        }

        previous.setNext(new Node(key, value, null));
    }

    public int get(int key) {
        int index = getIndex(key);

        Node head = values[index];

        if (head == null) {
            return -1;
        }

        return findValueNode(head.getNext(), key);
    }

    public void remove(int key) {
        int index = getIndex(key);

        Node head = values[index];

        if (head == null) {
            return;
        }

        removeFromBucket(head, key);
    }

    private void removeFromBucket(Node head, int key) {

        Node previous = head;
        Node current = head.getNext();

        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.getNext();
        }

        Node nextNode = current != null ? current.getNext() : null;
        previous.setNext(nextNode);
    }

    private int getIndex(int key) {
        return key % values.length;
    }

    private int findValueNode(Node node, int key) {
        Node search = node;
        while (search != null) {
            if (search.getKey() == key) {
                return search.getValue();
            }

            search = search.getNext();
        }

        return -1;
    }

    public static void main(String[] args) {
        DesignHashMap hashMap = new DesignHashMap();

        hashMap.put(2, 2);
        hashMap.put(2, 22);
        hashMap.put(3, 3);

        System.out.println(hashMap.get(3));

        hashMap.remove(3);

        System.out.println(hashMap.get(5));
    }


}
