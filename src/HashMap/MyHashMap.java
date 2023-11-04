package HashMap;

import java.util.Arrays;

public class MyHashMap<K, V> {

    private Entry<K, V>[] buckets;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void clear() {
        this.buckets = new Entry[10];
    }

    public int size(){
        return buckets.length;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            kvEntry.setNextEntry(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
    }

    public void remove(K key){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = checkEquals(currentEntry, key);
            currentEntry = currentEntry.getNextEntry();
        }
        currentEntry.setValue(null);
        currentEntry.setKey(null);
        buckets[bucketNumber] = currentEntry;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = checkEquals(currentEntry, key);
            if (v != null)
                return v;

            currentEntry = currentEntry.getNextEntry();
        }
        return checkEquals(currentEntry, key);

    }

    private V checkEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap();
        myHashMap.put("abc1", 1);
        myHashMap.put("abc2", 2);
        myHashMap.put("abc3", 3);
        myHashMap.put("abc4", 4);
        myHashMap.put("abc5", 5);
        myHashMap.put("abc6", 6);
        myHashMap.put("abc7", 7);
        myHashMap.put("abc8", 8);
        myHashMap.put("abc9", 9);
        myHashMap.put("abc10", 10);
        myHashMap.put("abc11", 11);

        System.out.println("myHashMap.get(\"abc9\") = " + myHashMap.get("abc9"));
        System.out.println("myHashMap.get(\"abc1\") = " + myHashMap.get("abc1"));
        System.out.println("myHashMap.get(\"abc11\") = " + myHashMap.get("abc11"));
        System.out.println("myHashMap.get(\"abc99\") = " + myHashMap.get("abc99"));

        myHashMap.remove("abc2");
        //System.out.println("myHashMap.get(\"abc2\") = " + myHashMap.get("abc2"));
        System.out.println("Size = " + myHashMap.size());
    }
}


