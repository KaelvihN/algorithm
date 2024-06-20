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
    public ListNode getIntersectionNodeByHash(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 双指针法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode idxA = headA, idxB = headB;
        int lenA = 0, lenB = 0;
        // 统计长度
        while (idxA != null) {
            lenA++;
            idxA = idxA.next;
        }
        while (idxB != null) {
            lenB++;
            idxB = idxB.next;
        }
        // 重置指针
        idxA = headA;
        idxB = headB;
        // 位移到同意起点
        int diff = lenA - lenB;
        while (diff > 0) {
            diff--;
            idxA = idxA.next;
        }
        while (diff < 0) {
            diff++;
            idxB = idxB.next;
        }
        while (idxA != null) {
            if (idxB == idxA) {
                return idxA;
            }
            idxA = idxA.next;
            idxB = idxB.next;
        }
        return null;
    }
}
