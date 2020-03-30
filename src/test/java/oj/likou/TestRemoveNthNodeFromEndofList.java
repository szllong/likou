package oj.likou;

import org.junit.Test;

import java.util.List;

public class TestRemoveNthNodeFromEndofList {

    @Test
    public void testRemove() {
        ListNode node = createNode();
        ListNode leftNode = removeNthFromEnd1(node, 4);
        System.out.println(leftNode);
    }

    private ListNode createNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        return node1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode aftN = head;
        while (n-- > 0 && aftN.next != null) {
            aftN = aftN.next;
        }

        if (n == 0 && null == aftN.next) {
            return head.next;
        }

        while (null != aftN.next) {
            aftN = aftN.next;
            pre = pre.next;
        }


        if (null != pre.next) {
            pre.next = pre.next.next;
            return head;
        } else {
            return null;
        }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
