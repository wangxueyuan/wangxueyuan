package other;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/8/2020 10:24
 * @Version: 1.0
 **/
public class MapTest {
    private static int next=0;
    public static void main(String[] args) {
        final MapTest mapTest = new MapTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mapTest.test();
                }
            }).start();
        }
    }


    public void test() {
        String[] urls = {"http://211.145.49.198/services/sensor/ingestion/didi", "http://211.145.49" +
                ".199/services/sensor/ingestion/didi"};
        System.out.println(urls[next++%2]);

    }
}
