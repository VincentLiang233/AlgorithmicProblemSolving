import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length;
        while((length = in.nextInt()) != 0) {
            List<Integer> values = new ArrayList<Integer>();
            for(int i = 0; i < length; i++) {
                values.add(in.nextInt());
            }
            int nPeaks = 0;

            // Approach 1: Ignore endpoints and handle them outside the loop

            // Approach 2: Modding

            for(int i = 0; i < length; i++) {
                int prevVal = values.get((i + length - 1) % length);
                int nextVal = values.get((i + 1) % length);
                int curVal = values.get(i);
                if((curVal > prevVal && curVal > nextVal) || (curVal < prevVal && curVal < nextVal)) {
                    nPeaks++;
                }
            }

            // Approach 3: Append the extreme values to beginning and end

            System.out.println(nPeaks);
        }
    }
}