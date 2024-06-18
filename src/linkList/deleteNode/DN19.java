package linkList.deleteNode;

import linkList.ListNode;

/**
 * @author: anran.ma
 * @created: 2024/6/18
 * @description: 删除链表的倒数第 N 个结点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 **/
public class DN19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new DN19().removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head), idx = res;
        int size = 0;
        while (idx != null) {
            size++;
            idx = idx.next;
        }
        idx = res;
        for (int i = 0; i < size - n - 1; i++) {
            idx = idx.next;
        }
        idx.next = idx.next.next;
        return res;
    }
}
