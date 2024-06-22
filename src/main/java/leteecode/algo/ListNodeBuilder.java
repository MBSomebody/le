package leteecode.algo;

public class ListNodeBuilder {
    public static ListNode buildListNodes() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node222 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node22;
        node22.next = node222;
        node222.next = node5;
        return node1;
    }

    public static ListNode buildPalindromeListNodes() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node222 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node22;
        node22.next = node222;
        node222.next = node5;
        return node1;
    }


}
