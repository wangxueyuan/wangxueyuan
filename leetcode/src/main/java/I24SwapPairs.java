/**
 * @Author: Wang X.Y.
 * @CreateTime: 8/18/2020 17:29
 * @Version: 1.0
 **/


public class I24SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            head = head.next.next;
        }

        return dummy.next;
    }
}
