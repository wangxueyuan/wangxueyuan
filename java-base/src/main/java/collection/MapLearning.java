package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/13/2020 18:30
 * @Version: 1.0
 **/
public class MapLearning {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map);

        Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1, 1);
        System.out.println(map);
    }
}
