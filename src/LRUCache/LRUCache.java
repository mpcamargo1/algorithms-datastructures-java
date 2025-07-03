package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;

    private LinkedList<Node> list = new LinkedList<>();

    class Node {

        private int key;
        private int value;

        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        list.remove(node);
        list.addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;

            list.remove(node);
            list.addFirst(node);

            return;
        }

        if (list.size() == capacity) {
            Node lastNode = list.removeLast();
            cache.remove(lastNode.key);
        }

        Node newNode = new Node(key, value);
        list.addFirst(newNode);

        cache.put(key, newNode);
    }

}

