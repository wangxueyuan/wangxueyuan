package map;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 8/4/2020 09:58
 * @Version: 1.0
 **/

class LRU<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRU(int capacity, float loadFactor) {
        super(capacity, loadFactor, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }

    public <K, V> Map.Entry<K, V> getTailByReflection(LinkedHashMap<K, V> map)
            throws NoSuchFieldException, IllegalAccessException {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Map.Entry<K, V>) tail.get(map);
    }
}

public class LinkedHashMapTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(5, 0.75f);
        LRU<Integer, Integer> lru = new LRU<>(5, 0.75f);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        lru.put(7, 7);
        System.out.println(lru.get(4));

        lru.put(8, 666);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        // 输出: {3=3, 5=5, 7=7, 4=4, 6=666}
        // 可以看到最旧的元素被删除了
        // 且最近访问的4被移到了后面
        System.out.println(lru);
        lru.remove(lru.entrySet().iterator().next().getKey());
    }
}
