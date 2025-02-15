package LRUCacheDesign;

public class Node {
    int val;
    int key;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        this.left = null;
        this.right = null;
    }
    int getVal() {
        return this.val;
    }

    void setVal(int val) {
        this.val = val;
    }
}
