package inout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class InOut {

    public static void main(String[] args) {
        File file = new File("D:\\learning\\java\\dataStructure\\test.txt");

        try (OutputStream os=new FileOutputStream(file,true)) {

            os.write("50".getBytes());
            os.write("\r\n".getBytes());
            os.write("over".getBytes());
//            os.write(Integer.parseInt("\r\n"));
//            os.write(Integer.parseInt("over"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
