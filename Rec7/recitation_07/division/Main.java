import java.util.*;
import java.util.stream.*;

public class Main {
    public static void addDigits(int num, Set<Integer> digits) {
        while(num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        boolean first = true;
        while((N = in.nextInt()) != 0) {
            if(first) {
                first = false;
            } else {
                System.out.println();
            }
            boolean found = false;
            for(int d = 1234; d <= 98765 / N; d++) {
                int n = d * N;
                if(n > 98765) {
                    break;
                }
                Set<Integer> digits = new HashSet<Integer>();
                addDigits(n, digits);
                addDigits(d, digits);
                if(d < 10000) digits.add(0);
                if(digits.size() == 10) {
                    found = true;
                    System.out.println(String.format("%05d / %05d = %d", n, d, N));
                }
            }
            if(!found) {
                System.out.println(String.format("There are no solutions for %d.", N));
            }
        }
    }
}
