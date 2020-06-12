/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/7/2020 17:49
 * @Version: 1.0
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class AddTwoNums {
    /**
     * 最优解
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy3 = new ListNode(0);
        ListNode result = new ListNode(0);
        dummy3.next = result;
        int overIndex=0;
        while (list1 != null || list2 != null) {
            int temp;
            int x = list1 != null ? list1.val : 0;
            int y = list2 != null ? list2.val : 0;
            if (overIndex > 0) {
                temp = x + y + 1;
            }else {
                temp = x + y;
            }
            if (temp >= 10) {
                result.next = new ListNode(temp % 10);
                result = result.next;
                overIndex = 1;
            }else {
                result.next = new ListNode(temp);
                result = result.next;
                overIndex = 0;
            }
            if(list1!=null)
                list1 = list1.next;
            if(list2!=null)
                list2 = list2.next;
        }

        if (overIndex > 0) {
            result.next = new ListNode(1);
        }
        return dummy3.next.next;
    }

}
