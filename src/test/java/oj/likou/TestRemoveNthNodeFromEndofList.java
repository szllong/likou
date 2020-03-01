package oj.likou;

import org.junit.Test;

public class TestRemoveNthNodeFromEndofList {

    @Test
    public void testRemove() {
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
}
