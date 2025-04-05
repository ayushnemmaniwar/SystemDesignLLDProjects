package HashMapImplementation.Entity;

public class Bucket<K,V> {
    ListNode head;
    public Bucket() {
        head=null;
    }


    public void put(K key, V value) {
        ListNode listNode = head;
        while (listNode!=null) {
            if(listNode.getKey().equals(key)) {
                listNode.setValue(value);
                return;
            }
            listNode=listNode.next;
        }
        ListNode temp = new ListNode<>(key,value);
        temp.next=head;
        head=temp;
    }

    public <V> V get(K key) {
        ListNode listNode = head;
        V value=null;
        while(listNode!=null) {
            if(listNode.getKey().equals(key)) {
                value = (V) listNode.getValue();
            }
            listNode=listNode.next;
        }
        if(value==null)
            System.out.println("Value not found");
        return value;
    }

    public void printBucket() {
        ListNode listNode = head;
        while(listNode!=null) {
            System.out.println(listNode.getKey()+" "+listNode.getValue());
            listNode=listNode.next;
        }
        System.out.println();
    }
}
