package jvm;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    // 一个大的ArrayLis，内部是随机的整形数据
    volatile List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 133, 431, 43143, 332, 31431, 3143, 21341, 34314, 3113, 32515, 56, 674, 68648, 68555, 5367, 875, 79759, 759799, 75789, 7759895, 7587595);
    // 基准测试1
    public int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        return max;
    }
    // 基准测试2
    public int lambdaMaxInteger() {
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }
}
