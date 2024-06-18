package linkList.designLinkList;

/**
 * @author: anran.ma
 * @created: 2024/6/16
 * @description: 设计链表 https://leetcode.cn/problems/design-linked-list/description/
 **/
public class DLL707 {
    public static void main(String[] args) {

    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(index, 0);
        size++;
        Node idx = head;
        for (int i = 0; i < index; i++) {
            idx = idx.next;
        }
        idx.next = new Node(val, idx.next);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }


    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        Node idx = head;
        for (int i = 0; i < index; i++) {
            idx = idx.next;
        }
        idx.next = idx.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}