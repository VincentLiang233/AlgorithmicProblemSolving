import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class a {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            String[] info = in.readLine().split(" ");
            int citizens = Integer.parseInt(info[0]);
            int pairs = Integer.parseInt(info[1]);
            UnionFind set = new UnionFind(citizens+1);
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < pairs; i ++){
                String[] line = in.readLine().split(" ");
                int A = Integer.parseInt(line[0]);
                int B = Integer.parseInt(line[1]);
                set.union(A,B);
            }
            int max = 0;
            for (int j = 0; j < set.parent.length; j ++){
                int groups = set.find(j);
                if (!map.containsKey(groups)){
                    map.put(groups,1);
                }else{
                    map.replace(groups,map.get(groups)+1);
                }
                max = Math.max(max, map.get(groups));
            }
            out.write(max+"");
            out.newLine();
            out.flush();
            kases --;
        }
    }


    static class UnionFind
    {
        int[] rank, parent;
        int n;

        public UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            for (int i=0; i<n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
            }
        }


        int find(int x) {
            if (parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y)
        {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot){
                return;
            }

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            }
            else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            }
            else{
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }
}
