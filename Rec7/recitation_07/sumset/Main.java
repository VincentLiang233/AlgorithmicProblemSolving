import java.util.*;

public class Main {
    static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int sum() {
            return first + second;
        }

        public int diff() {
            return second - first;
        }

        public boolean overlaps(Pair p) {
            return this.first == p.first || this.second == p.second;
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
            return this.diff();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numInputs;
        while((numInputs = in.nextInt()) != 0) {
            List<Integer> nums = new ArrayList<Integer>();
            for(int i = 0; i < numInputs; i++) {
                nums.add(in.nextInt());
            }
            Collections.sort(nums);
            Map<Integer, Set<Pair>> sums = new HashMap<Integer, Set<Pair>>();
            for(int i = 0; i < nums.size(); i++) {
                for(int j = i + 1; j < nums.size(); j++) {
                    Pair p = new Pair(nums.get(i), nums.get(j));
                    Set<Pair> pairs;
                    if(sums.containsKey(p.sum())) {
                        pairs = sums.get(p.sum());
                    } else {
                        pairs = new HashSet<Pair>();
                        sums.put(p.sum(), pairs);
                    }
                    pairs.add(p);
                }
            }
            int max = Integer.MIN_VALUE;
            outerloop:
            for(int i = nums.size() - 1; i >= 0; i--) {
                for(int j = 0; j < i; j++) {
                    Pair p = new Pair(nums.get(j), nums.get(i));
                    if(sums.containsKey(p.diff())) {
                        Set<Pair> pairs = sums.get(p.diff());
                        for(Pair pair : pairs) {
                            if(!pair.overlaps(p)) {
                                max = p.second;
                                break outerloop;
                            }
                        }
                    }
                }
            }
            if(max != Integer.MIN_VALUE) {
                System.out.println(max);
            } else {
                System.out.println("no solution");
            }
        }
    }
}
