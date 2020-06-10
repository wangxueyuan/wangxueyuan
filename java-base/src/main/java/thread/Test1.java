package thread;

public class Test1 {
    private static long x = 0;
    private static long y = 0;
    private static long a = 0;
    private static long b = 0;
    volatile private static long c = 0;
    volatile private static long d = 0;
    private static long e = 0;
    private static long f = 0;

    private static long count=0;

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            count++;
            Thread t1=new Thread(new Runnable() {
                @Override
                public void run() {
                    x=b;
                    c=101;
                    a=1;
                }
            });
            Thread t2=new Thread(new Runnable() {
                @Override
                public void run() {
                    y=a;
                    d=201;
                    b=1;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String showString = String.format("count=%d x=%d y=%d", count, x, y);
            if (x == 0 && y == 0) {
                System.err.println(showString);
            } else {
                System.out.println(showString);
            }
        }
    }
}
