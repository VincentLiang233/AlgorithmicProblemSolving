import java.util.*;
import java.util.stream.*;

public class Main {
    static class Elephant implements Comparable<Elephant> {
        public int id;
        public int weight;
        public int iq;

        public Elephant(int id, int weight, int iq) {
            this.id = id;
            this.weight = weight;
            this.iq = iq;
        }

        @Override
        public int compareTo(Elephant other) {
            return this.iq - other.iq;
        }

        @Override
        public String toString() {
            return "" + this.id;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int id = 1;
        List<Elephant> elephants = new ArrayList<Elephant>();
        while(in.hasNextInt()) {
            elephants.add(new Elephant(id++, in.nextInt(), in.nextInt()));
        }
        Collections.sort(elephants, Collections.reverseOrder());
        
        List<List<Elephant>> lis = new ArrayList<List<Elephant>>();

        // base case, the first element by itself
        List<Elephant> maxLis = new ArrayList<Elephant>();
        maxLis.add(elephants.get(0));
        lis.add(maxLis);

        for(int i = 1; i < elephants.size(); i++) {
            // each element by themselves is a candidate
            Elephant curElephant = elephants.get(i);
            maxLis = new ArrayList<Elephant>();
            maxLis.add(curElephant);
            for(int j = 0; j < i; j++) {
                List<Elephant> prevLis = lis.get(j);
                Elephant last = prevLis.get(prevLis.size() - 1);
                if(curElephant.weight > last.weight &&
                   curElephant.iq < last.iq &&
                   prevLis.size() + 1 > maxLis.size()) {
                    maxLis = new ArrayList<Elephant>(prevLis);
                    maxLis.add(curElephant);
                }
            }
            lis.add(maxLis);
        }

        maxLis = null;
        for(List<Elephant> l : lis) {
            if(maxLis == null || l.size() > maxLis.size()) {
                maxLis = l;
            }
        }
        System.out.println(maxLis.size());
        for(Elephant e : maxLis) {
            System.out.println(e);
        }
    }
}
