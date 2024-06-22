package leteecode.algo;

import java.util.List;

public class ReverseList {


    public ListNode reverseList(ListNode listNode) {
        /**
         * 终止条件： 找到倒数第二个节点
         * 思路： 通过递归找到末尾节点，完成尾部翻转。
         *  通过递归的逐层返回，把当前节点放到新链表的末尾（curr.next.next 没有翻转的链表尾部也是翻转链表的尾部）
         *  1 -》 2 -》 3 -》4 《- 5
         */
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        // 递归后移到n-2个节点，
        // 第一个当前节点是 4号
        // 第二个当前节点是3号节点。
        ListNode newHead = reverseList(listNode.next);

        // 当前节点的后继节点【最后一个节点】，next指针指向当前节点，
        // 第一轮中5 号节点的next 指向4. 完成了 45 的逆转。
        // 第二轮 3节点next 的4 节点的next指针，指向当前 3. 完成 5 - 4 -3
        listNode.next.next = listNode;
        // 断开 4 到 5 的链接
        listNode.next = null;

        PrintUtil.print(newHead);
        return newHead;

    }

    public ListNode reverse2(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode prev = null;
        ListNode curr = listNode;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeBuilder.buildListNodes();
        PrintUtil.print(listNode);
        ListNode listNode1 = new ReverseList().reverse2(listNode);
        PrintUtil.print(listNode1);
    }
}
