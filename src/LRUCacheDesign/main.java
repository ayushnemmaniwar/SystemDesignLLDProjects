package LRUCacheDesign;

public class main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.put(3,30);
        lruCache.put(4,40);
        int val;
        val = lruCache.get(2);
        System.out.println(val);
        val = lruCache.get(1);
        System.out.println(val);
        lruCache.put(4,50);
        val = lruCache.get(4);
        System.out.println(val);
    }
}
