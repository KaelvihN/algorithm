package linkList.circularLinkList;

import linkList.ListNode;

/**
 * @author: anran.ma
 * @created: 2024/6/20
 * @description: 环形链表 II https://leetcode.cn/problems/linked-list-cycle-ii/description/
 **/
public class CLL142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
