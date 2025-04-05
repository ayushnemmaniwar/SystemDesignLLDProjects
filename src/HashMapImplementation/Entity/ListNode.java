package HashMapImplementation.Entity;

public class ListNode<K,V> {
    private K key;
    private V value;
    ListNode<K,V> next;

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
        next=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
