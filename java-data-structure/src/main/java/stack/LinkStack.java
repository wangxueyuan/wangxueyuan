package stack;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/7/2020 16:33
 * @Version: 1.0
 **/
public class LinkStack {
    private String[] items;
    private int count;  //元素个数
    private int n;      //栈大小

    public LinkStack(int n) {
        this.n=n;
        items = new String[n];
        this.count=0;
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;

        return true;
    }

    public String pop() {
        if(count==0) {
            return null;
        }
        String temp = items[count - 1];
        --count;
        return temp;
    }
}
