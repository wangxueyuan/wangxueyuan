package thread;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 7/14/2020 13:28
 * @Version: 1.0
 **/
public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton singleton;
    private static Object object = new Object();

    public static DoubleCheckLockSingleton getInstance() {
        if (singleton == null) {
            singleton = new DoubleCheckLockSingleton();
        }
        return singleton;
    }

    public synchronized static DoubleCheckLockSingleton getInstance2() {
        if (singleton == null) {
            singleton = new DoubleCheckLockSingleton();
        }
        return singleton;
    }

    public synchronized static DoubleCheckLockSingleton getInstance3() {
        if (singleton == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLockSingleton();
                }
            }

        }
        return singleton;
    }
}
