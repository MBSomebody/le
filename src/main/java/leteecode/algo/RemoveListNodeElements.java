package leteecode.algo;

public class RemoveListNodeElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        dummy = remove2(dummy, val);
        return dummy.next;

//        return dummy.next;

    }

    private void remove(ListNode head, ListNode pre, int v) {
        if (head == null) {
            return;
        }
        if (head.val == v) {
            pre.next = head.next;
            remove(head.next, pre, v);
        } else {
            remove(head.next, pre.next, v);
        }
    }

    private ListNode remove2(ListNode head, int v) {
        if (head == null) {
            return head;
        }

        if (head.val == v) {
            return head.next;
        }
        head.next = remove2(head.next, v);
        return head;
    }

    public static void main(String[] args) {
        RemoveListNodeElements removeListNodeElements = new RemoveListNodeElements();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(100);
        ListNode node22 = new ListNode(10099);
        ListNode node222 = new ListNode(1009999);
        node1.next = node2;
        node2.next = node22;
        node22.next = node222;
        ListNode listNode = removeListNodeElements.removeElements(node1, 100);
        PrintUtil.print(listNode);
    }
}
