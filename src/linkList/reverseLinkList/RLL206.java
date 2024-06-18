package linkList.reverseLinkList;

import linkList.ListNode;

/**
 * @author: anran.ma
 * @created: 2024/6/17
 * @description: 反转链表 https://leetcode.cn/problems/reverse-linked-list/description/
 **/
public class RLL206 {
    /**
     * 常规法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = reverse(cur.next, cur);
        cur.next = pre;
        return res;
    }

    public static void main(String[] args) {
        ListNode header = new ListNode();
        header.next = new ListNode(1);
        header.next.next = new ListNode(2);
        header.next.next.next = new ListNode(3);
        header.next.next.next.next = new ListNode(4);
        header.next.next.next.next.next = new ListNode(5);
        ListNode listNode = new RLL206().reverseList2(header);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}


