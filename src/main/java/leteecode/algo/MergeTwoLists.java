package leteecode.algo;

import java.util.List;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//        ListNode d = new ListNode(-1);
//        merge(list1, list2, d);
//        return d.next;

        return merge(list1, list2);

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        int a = list1.val;
        int b = list2.val;
        if (a < b) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    private void merge2(ListNode list1, ListNode list2, ListNode head) {
        if (list1 == null) {
            head.next = list2;
            return;
        }

        if (list2 == null) {
            head.next = list1;
            return;
        }

        int a = list1.val;
        int b = list2.val;
        if (a < b) {
            head.next = list1;
            merge2(list1.next, list2, head.next);
        } else {
            head.next = list2;
            merge2(list1, list2.next, head.next);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(100);
        ListNode node22 = new ListNode(10099);
        ListNode node222 = new ListNode(1009999);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node22;
        node22.next = node222;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = new MergeTwoLists().mergeTwoLists(node1, node3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
