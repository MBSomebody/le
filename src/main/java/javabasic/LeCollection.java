package main.java.javabasic;

import java.io.Serializable;
import java.util.*;

public class LeCollection {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.set(1, 2);
        integers.add(3);
        integers.remove(1);
        integers.size();
        integers.contains(1);
        for (int i : integers) {
            System.out.println(i);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.offer("c");
        System.out.println(linkedList.peek());
        for (String s : linkedList
        ) {
            System.out.println(s);
        }


        System.out.println("---");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.remove("a");
        System.out.println(map.keySet());
        for (String c : map.keySet()) {
            System.out.println(c + map.get(c));
        }
        System.out.println("--");
        TreeMap<String, Integer> map2 = new TreeMap<String, Integer>((k, k2) -> -1 * k.compareTo(k2));
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);
        System.out.println(map2);
        map2.remove("a");
        System.out.println(map2);
        System.out.println(map2.firstEntry());

        System.out.println("----");
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(2));


        System.out.println("__");
        class Book implements Serializable {
            private String bookName;

            private int prt = 0;

            public Book(String bookName, int prt) {
                this.bookName = bookName;
                this.prt = prt;
            }


        }
        PriorityQueue<Book> books = new PriorityQueue<>((o, k) -> k.prt - o.prt);
        books.add(new Book("a", 1));
        books.add(new Book("b", 10));
        books.add(new Book("c", 100));
        System.out.println(books);
        System.out.println(books.peek());


        List<Integer> objects = Collections.emptyList();
        int[] arr = {100, 1, 5};
        Arrays.sort(arr);
        Collections.sort(objects);
        System.out.println(Arrays.toString(arr));

        float u = 1.0f;

    }
}
