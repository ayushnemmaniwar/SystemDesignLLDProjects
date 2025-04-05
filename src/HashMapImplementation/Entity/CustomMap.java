package HashMapImplementation.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomMap<K,V> {
    int capacity;
    List<Bucket<K,V>> bucketList;

    public CustomMap(int capacity) {
        this.capacity=capacity;
        bucketList=new ArrayList<>();
        for(int i=0;i<capacity;i++) {
            bucketList.add(new Bucket<>());
        }
    }
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Bucket bucket = bucketList.get(bucketIndex);
        bucket.put(key,value);
    }

    private int getBucketIndex(K key) {
        int hashValue = Math.abs(key.hashCode());
        return hashValue%capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Bucket bucket = bucketList.get(bucketIndex);
        return (V) bucket.get(key);
    }

    public void printMap() {
        for(Bucket bucket:bucketList) {
            bucket.printBucket();
        }
    }


}
