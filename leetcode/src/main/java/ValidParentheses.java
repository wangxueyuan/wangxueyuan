import java.util.Stack;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/7/2020 17:26
 * @Version: 1.0
 **/
public class ValidParentheses {
    //优解
    public static boolean isValid2(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        if (s.length() % 2 > 0) {
            return false;
        }
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }

    //个人解
    public static boolean isValid(String s) {
        if(s==null||s.isEmpty()){
            return true;
        }
        int[] record=new int[s.length()];
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                record[count]=1;
                ++count;
            }
            if(s.charAt(i)=='['){
                record[count]=2;
                ++count;
            }
            if(s.charAt(i)=='{'){
                record[count]=3;
                ++count;
            }
            if(s.charAt(i)==')'){
                if(count==0){
                    return false;
                }
                record[count-1]-=1;
                --count;
            }
            if(s.charAt(i)==']'){
                if(count==0){
                    return false;
                }
                record[count-1]-=2;
                --count;
            }
            if(s.charAt(i)=='}'){
                if(count==0){
                    return false;
                }
                record[count-1]-=3;
                --count;
            }
        }
        for(int j=0;j<s.length();j++){
            if(record[j]!=0){
                return false;
            }
        }
        return true;
    }
}
