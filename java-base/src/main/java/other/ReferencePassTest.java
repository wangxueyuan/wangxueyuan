package other;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/17/2020 23:15
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
class User {
    private int id;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}

public class ReferencePassTest {
    public static void main(String[] args) {
        ReferencePassTest rpt = new ReferencePassTest();
        User user = new User(1, 21);
        rpt.change(user);
        System.out.println(user.toString());

        int num = 10;
        rpt.changeNum(num);
        System.out.println(num);

        String s = "bb";
        rpt.changeString(s);
        System.out.println(s);
    }

    public User change(User user) {
        user = new User(2, 22);
        System.out.println(user);
        return user;
    }

    public void changeNum(int num) {
        num = 20;
    }

    public void changeString(String s) {
        s = "aaaa";
    }
}
