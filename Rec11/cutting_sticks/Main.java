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
            return this.first + this.second * 1000;
        }
    }

    public static int findValue(Map<Pair, Integer> results, List<Integer> cuts, Pair p) {
        if(results.containsKey(p)) {
            return results.get(p);
        } else {
            if(p.first + 1 == p.second) {
                return 0;
            }
            int minCost = Integer.MAX_VALUE;
            for(int i = p.first + 1; i < p.second; i++) {
                int cost = findValue(results, cuts, new Pair(p.first, i))
                            + (cuts.get(p.second) - cuts.get(p.first))
                            + findValue(results, cuts, new Pair(i, p.second));
                if(cost < minCost) {
                    minCost = cost;
                }
            }
            results.put(p, minCost);
            return minCost;
        }
    }
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        while(length > 0) {
            int nCuts = in.nextInt();
            List<Integer> cuts = new ArrayList<Integer>();
            cuts.add(0);
            for(int i = 0; i < nCuts; i++) cuts.add(in.nextInt());
            cuts.add(length);
            Map<Pair, Integer> results = new HashMap<Pair, Integer>();
            System.out.println("The minimum cutting is " + findValue(results, cuts, new Pair(0, cuts.size() - 1)) + ".");
            length = in.nextInt();
        }
    }
}
