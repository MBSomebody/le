package leteecode.algo;

import java.util.List;

public class ListNode {

    public int val;
    public ListNode pre;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode pre, ListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
