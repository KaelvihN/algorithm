package linkList.removeEle;

import linkList.ListNode;

import java.util.Objects;

/**
 * @author: anran.ma
 * @created: 2024/6/12
 * @description: 移除链表元素 https://leetcode.cn/problems/remove-linked-list-elements/description/
 **/
public class RE203 {

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode idx = res;
        while (idx.next != null) {
            if (idx.next.val == val) {
                idx.next = idx.next.next;
            }else {
                idx = idx.next;
            }
        }
        return res.next;
    }
}
