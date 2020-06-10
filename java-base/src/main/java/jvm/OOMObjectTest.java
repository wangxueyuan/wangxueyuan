package jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMObjectTest {
    static class OOMObject{
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void filleHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(80);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        Thread.sleep(6000);
        System.out.println("Sleep is over");
        filleHeap(1000);
        System.out.println("Start to execute gc work");
        System.gc();
        System.out.println("Gc is over");
        Thread.sleep(10000);
    }
}
