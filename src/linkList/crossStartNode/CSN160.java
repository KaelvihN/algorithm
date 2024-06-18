package linkList.crossStartNode;

import linkList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: anran.ma
 * @created: 2024/6/18
 * @description:链表相交 https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 **/
public class CSN160 {
    /**
     * Hash法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
