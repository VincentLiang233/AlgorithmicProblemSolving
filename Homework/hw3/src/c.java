import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class c {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        while (line != null){
            int days = Integer.parseInt(line);
            if (days == 0){
                break;
            }
            long output = 0;
            TreeSet<Integer> treeSet = new TreeSet<>();
            //space for time
            int[] table = new int[1000005];
            while (days > 0){
                String[] kcase = in.readLine().split(" ");
                int kcases = Integer.parseInt(kcase[0]);
                for (int i = 1; i < kcases + 1; i++){
                    int x = Integer.parseInt(kcase[i]);
                    treeSet.add(x);
                    table[x] += 1;
                }
                //at the end of each day get an answer
                //for sure there are at least 2 bills
                int min = treeSet.first();
                int max = treeSet.last();
                output += (max - min);
                table[max]-=1;
                table[min]-=1;
                if (table[max] == 0){
                    treeSet.remove(max);
                }
                if (table[min] == 0){
                    treeSet.remove(min);
                }
                days --;
            }
            System.out.println(output);
            line = in.readLine();
        }
    }
}
