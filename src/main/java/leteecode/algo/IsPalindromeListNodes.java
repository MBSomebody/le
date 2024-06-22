package leteecode.algo;

public class IsPalindromeListNodes {

    private ListNode oHead = null;

    public boolean isPalindrome(ListNode head) {
        oHead = head;
        return check(head);
    }

    public boolean check(ListNode curr) {

        if (curr == null) {
            return true;
        }

        boolean checkRes = check(curr.next);
        if (checkRes) {
            boolean res = oHead.val == curr.val;
            oHead = oHead.next;
            return res;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        ListNode listNode = ListNodeBuilder.buildPalindromeListNodes();
        ListNode listNode = ListNodeBuilder.buildListNodes();
        boolean palindrome = new IsPalindromeListNodes().isPalindrome(listNode);
        System.out.println(palindrome);
    }
}
