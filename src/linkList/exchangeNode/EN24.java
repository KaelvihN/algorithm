package linkList.exchangeNode;

import linkList.ListNode;

/**
 * @author: anran.ma
 * @created: 2024/6/18
 * @description: 两两交换链表中的节点 https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 **/
public class EN24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        ListNode swapPairs = new EN24().swapPairs(listNode);
        while (swapPairs != null) {
            System.out.println(swapPairs.val);
            swapPairs = swapPairs.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = new ListNode(), mid = head, fast = head.next,res = slow;
        while (true){
            slow.next = fast;
            mid.next = fast.next;
            fast.next = mid;
            if (mid.next ==null || mid.next.next == null) {
                break;
            }
            fast = mid.next.next;
            slow = mid;
            mid = mid.next;
        }
        return res.next;
    }
}
