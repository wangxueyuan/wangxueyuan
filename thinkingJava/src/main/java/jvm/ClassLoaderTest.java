package jvm;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 11/29/2019 20:26
 * @Description:
 * @Version: 1.0
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        bootClassLoaderPath();

        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
    }

    private static void bootClassLoaderPath(){
        String path = System.getProperty("sun.boot.class.path");
        for(String res:path.split(";")){
            System.out.println(res);
        }
    }
}
