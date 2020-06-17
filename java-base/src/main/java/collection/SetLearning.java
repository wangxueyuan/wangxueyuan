package collection;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/13/2020 17:57
 * @Version: 1.0
 **/
public class SetLearning {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(87);
        treeSet.add(80);
        treeSet.add(32143);
        System.out.println(treeSet);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(314);
        hashSet.add(143);
        hashSet.add(3143);
        hashSet.add(2);
        System.out.println(hashSet);
    }
}
