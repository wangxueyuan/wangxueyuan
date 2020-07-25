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
public class I2AddTwoNums {
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
            int sum=0;
            if (list1 != null) {
                sum+=list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum+=list2.val;
                list2 = list2.next;
            }
            sum += overIndex;
            result.next = new ListNode(sum % 10);
            if (sum >= 10) {
                overIndex = 1;
            }else {
                overIndex = 0;
            }
            result = result.next;
        }

        if (overIndex > 0) {
            result.next = new ListNode(1);
        }
        return dummy3.next.next;
    }

}
