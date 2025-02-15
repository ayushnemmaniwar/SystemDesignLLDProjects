package LRUCacheDesign;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, Node> nodeHashMap;
    private final int capacity;
    private int currentSize;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.nodeHashMap = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public void put(int key, int val) {
        if (nodeHashMap.containsKey(key)) {
            updateExistingNode(key, val);
            return;
        }

        Node node = new Node(key, val);
        if (currentSize == capacity) {
            removeLast();
        }
        insertFirst(node);
        nodeHashMap.put(key, node);
        currentSize = Math.min(currentSize + 1, capacity);
    }

    private void updateExistingNode(int key, int val) {
        Node node = nodeHashMap.get(key);
        node.val = val;

        // Remove node from its current position
        removeNode(node);

        // Move node to front (most recently used)
        insertFirst(node);
    }

    private void removeLast() {
        if (tail == null) return; // Safety check

        // Remove the least recently used node (tail)
        nodeHashMap.remove(tail.key);
        if (tail.left != null) {
            tail.left.right = null;
        } else { // Single node case
            head = null;
        }
        tail = tail.left;
    }

    private void insertFirst(Node node) {
        if (head == null) { // First node being added
            head = node;
            tail = node;
        } else {
            node.right = head;
            head.left = node;
            head = node;
        }
    }

    private void removeNode(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else { // node is head
            head = node.right;
        }
        if (node.right != null) {
            node.right.left = node.left;
        } else { // node is tail
            tail = node.left;
        }
    }

    public int get(int key) {
        if (!nodeHashMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeHashMap.get(key);
        // Move the accessed node to the front (most recently used)
        updateExistingNode(key, node.val);
        return node.val;
    }
}