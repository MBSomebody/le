package leteecode.algo;

import java.util.List;

public class PrintUtil {

    public static void print(List<Object> list) {

        for (Object o : list) {
            System.out.print(o + " ,");
        }
        System.out.println();

    }

    public static void print(ListNode list) {
        ListNode d = list;
        while (d != null) {
            System.out.print(d.val + " ,");
            d = d.next;
        }
        System.out.println();

    }


}
