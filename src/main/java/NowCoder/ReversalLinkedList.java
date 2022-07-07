package NowCoder;

/**
 * ClassName: ReversalLinkedList
 * Author: ChenLun
 * date: 2021/10/26
 * Description:
 */
public class ReversalLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }

        return pre;
    }
}
