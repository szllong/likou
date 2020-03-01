package oj.likou;

import org.junit.Test;

public class TestAddTwoNumbers {

    @Test
    public void testAdd(){

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (null != p1 || null != p2){
            if (null != p1){
                sum += p1.val;
                p1 = p1.next;
            }

            if (null != p2){
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= sum;
        }

        if (1 == sum){
            cur.next = new ListNode(1);
        }
        return cur;
    }
}
