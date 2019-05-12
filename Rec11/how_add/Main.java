import java.util.*;
import java.util.stream.*;

public class Main {
    static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            return this.first == p.first && this.second == p.second;
        }

        @Override
        public int hashCode() {
            return this.first + this.second * 101;
        }
    }

    public static int findValue(Map<Pair, Integer> results, Pair p) {
        if(results.containsKey(p)) {
            return results.get(p);
        } else {
            if(p.second == 1) {
                return 1;
            }
            int res = 0;
            for(int i = 0; i <= p.first; i++) {
                res = (res + findValue(results, new Pair(i, p.second - 1))) % 1000000;
            }
            results.put(p, res);
            return res;
        }
    }
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Pair, Integer> results = new HashMap<Pair, Integer>();
        Pair p = new Pair(in.nextInt(), in.nextInt());
        while(p.first > 0 || p.second > 0) {
            System.out.println(findValue(results, p));
            p = new Pair(in.nextInt(), in.nextInt());
        }
    }
}
