package leteecode.algo;

import java.util.*;

public class MatrixTurn{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String line = null;
        int r = 0;
        int c = 0;
        List<List<String>> s = new ArrayList();
        while(sc.hasNextLine()){
            line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            s.add(Arrays.asList( line.trim().split(" ")));
            r++;
        }
        List<List<String>> res = new ArrayList();

        for(int i= 0; i<s.get(0).size(); i++){
            List<String> t = new ArrayList();
            for(List<String> ls : s){
                System.out.print(ls.get(i)+" ");
            }
            System.out.println();
        }

    }
}
