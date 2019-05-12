import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kcases = Integer.parseInt(in.readLine());
        DisjointSets S = new DisjointSets(500000);
        for (int i = 0; i < kcases; i++){
            HashSet<Integer> sets = new HashSet<>();
            ArrayList<Integer> keys = new ArrayList<>();
            String[] line = in.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            for (int j = 1; j < k; j ++){
                int num = Integer.parseInt(line[i]);
                if (sets.add(S.find(num))){
                    keys.add(num);
                }
            }
            int size = keys.size();
            for (int a = 0; a < size-1; a++){
                S.union(keys.get(a), keys.get(a+1));
            }
        }
        int counter = 0;
        for (int z = 0; z < S.array.length; z++){
            if (S.array[z] < 0){
                counter += 1;
            }
        }
        out.write(counter + "");
        out.flush();
        out.close();
    }
    static class DisjointSets {

        public int[] array;

        /**
         *  Construct a disjoint sets object.
         *
         *  @param numElements the initial number of elements--also the initial
         *  number of disjoint sets, since every element is initially in its own set.
         **/
        public DisjointSets(int numElements) {
            array = new int [numElements];
            for (int i = 0; i < array.length; i++) {
                array[i] = -1;
            }
        }
        public void union(int root1, int root2) {
            if (array[root2] < array[root1]) {
                array[root1] = root2;             // root2 is taller; make root2 new root
            } else {
                if (array[root1] == array[root2]) {
                    array[root1]--;            // Both trees same height; new one is taller
                }
                array[root2] = root1;       // root1 equal or taller; make root1 new root
            }
        }

        public int find(int x) {
            if (array[x] < 0) {
                return x;                         // x is the root of the tree; return it
            } else {
                // Find out who the root is; compress path by making the root x's parent.
                array[x] = find(array[x]);
                return array[x];                                       // Return the root
            }
        }
    }

}
