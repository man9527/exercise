package leetcode2;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1,2);
        cache.put(2,3);
        System.out.println(cache.get(1));
        cache.put(3,4);
        System.out.println(cache.get(2));
    }
    private LinkedList<Entry> accessList = new LinkedList<>();
    private HashMap<Integer, Entry> map = new HashMap<>();

    private int capacity = 0;
    private int currentSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key)==null) {
            return -1;
        }

        Entry index = map.get(key);

        accessList.remove(index);
        accessList.addLast(index);

        return index.value;
    }

    public void put(int key, int value) {

        if (map.get(key)!=null) {
            Entry entry = map.remove(key);
            accessList.remove(entry);
            currentSize--;
        } else if (currentSize+1>capacity) {
            Entry e = accessList.removeFirst();
            map.remove(e.key);
            currentSize--;
        }

        currentSize++;
        Entry newE = new Entry();
        newE.key = key;
        newE.value = value;
        map.put(key, newE);
        accessList.addLast(newE);
    }

    static class Entry {

        int key;
        int value;
    }
}
