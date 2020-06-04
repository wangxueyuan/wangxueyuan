package linklist;


/**
 * @Author: Wang X.Y.
 * @CreateTime: 6/3/2020 14:27
 * @Version: 1.0
 **/
public class NodeTest {
    /**
     * 增加链表节点
     * @param head
     * @param data
     * @return
     */
    public static LinkNode add(LinkNode head, int data) {
        LinkNode result = head;
        if (head == null) {
            head.data = data;
            return head;
        } else if (head.next == null) {
            head.next = new LinkNode(data);
            return head;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = new LinkNode(data);
        return result;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printNode(LinkNode head) {
        System.out.println("Start to print node details...");

        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        StringBuilder sb = new StringBuilder();
        while (dummy.next != null) {
            sb.append(dummy.next.data);
            sb.append("-");
            dummy = dummy.next;
        }
        System.out.println(sb.toString().substring(0, sb.length()-1));
    }

    /**
     * 链表长度
     * @param head
     * @return
     */
    public static int lengthOfLinkNode(LinkNode head) {
        int length = 0;
        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        while (dummy.next != null) {
            length++;
            dummy = dummy.next;
        }
        return length;
    }

    /*
    反转链表
     */
    public static LinkNode reverseNode(LinkNode head) {
        LinkNode pre = null;
        LinkNode next = null;
        while (head != null) {
            next = head.next;
            head.next=pre;
            pre=head;
            head = next;
        }
        return pre;
    }

    /*
    合并链表
     */
    public static LinkNode mergeTwoSortedLinkList(LinkNode list1, LinkNode list2) {
        LinkNode dummy1 = new LinkNode(0);
        LinkNode dummy2 = new LinkNode(0);
        dummy1.next = list1;
        dummy2.next = list2;
        LinkNode dummy3 = new LinkNode(0);
        LinkNode res = dummy3;

        while (dummy1.next != null && dummy2.next != null) {
            if (dummy1.next.data > dummy2.next.data) {
                dummy3.next = new LinkNode(dummy2.next.data);
                dummy3 = dummy3.next;
                dummy2 = dummy2.next;
                continue;
            } else {
                dummy3.next = new LinkNode(dummy1.next.data);
                dummy3 = dummy3.next;
                dummy1 = dummy1.next;
                continue;
            }
        }
        if (dummy1.next != null) {
            dummy3.next = dummy1.next;
        }
        if (dummy2.next != null) {
            dummy3.next = dummy2.next;
        }
        return res.next;
    }

    public static void deleteReverseNthNode(LinkNode head, int n) {

    }

    public static LinkNode addNthNode(LinkNode head, int n,int data) {
        if (n < 0) {
            System.out.println("the position must be over 0");
            return null;
        }
        LinkNode newNode = new LinkNode(data);

        //头部插入
        if (head == null && n > 0) {
            System.out.println("The head is null and cannot add data at Nth position ");
            return null;
        } else if (n==0){
            newNode.next = head;
            return newNode;
        }

        int index=0;
        LinkNode dummy = new LinkNode();
        dummy.next = head;

        while (dummy != null) {
            if (index++ == n) {
                newNode.next = dummy.next;
                dummy.next = newNode;
            }
            dummy = dummy.next;
        }
        if (n>=index) {
            System.out.println("超出范围");
            return null;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkNode node = new LinkNode(4);
        System.out.println(lengthOfLinkNode(node));
        add(node, 5);
        add(node, 7);
        add(node, 8);
        System.out.println(lengthOfLinkNode(node));
        printNode(node);

        LinkNode node2 = new LinkNode(3);
        System.out.println(lengthOfLinkNode(node));
        add(node2, 6);
        add(node2, 17);
        add(node2, 18);
        LinkNode newNode=addNthNode(node2, 5, 5);
        printNode(newNode);

      /*  LinkNode mergeNode = mergeTwoSortedLinkList(node, node2);
        printNode(mergeNode);

        LinkNode reverseNode=reverseNode(mergeNode);
        printNode(reverseNode);*/

    }
}
