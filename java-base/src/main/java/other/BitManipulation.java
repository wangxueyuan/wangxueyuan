package other;

public class BitManipulation {
    public static void main(String[] args) {
        /*int i=3;
        System.out.println(Integer.toBinaryString(i));
        i >>= 2;
        System.out.println(Integer.toBinaryString(i));

        String[] contents = {null,"abcd", "deviceId", "dfafdsa"};

        String key = Joiner.on("|").skipNulls().join(contents);
        System.out.println(key);
        Long jobId = System.currentTimeMillis();
        Long pickupId = System.currentTimeMillis();
        String callbackId = "fdafdsaf";
        String makeupKey = String.format("%s|%s|%s", jobId, pickupId, callbackId);
        System.out.println(makeupKey);
        callbackId = "jkjafd";
        System.out.println(callbackId);*/

//        Consumer<Long> consumer = null;
//        consumer.accept(10L);
        System.out.println(replaceSpace(new StringBuffer("we are happy")));
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");

            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
