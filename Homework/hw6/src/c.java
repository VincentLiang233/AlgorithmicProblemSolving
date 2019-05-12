import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class c {
    static private int[] parents = new int[10005];
    static private int[] book = new int[10005];

    private static int find(int x){
        if (parents[x] == x){
            return x;
        }else{
            int root = find(parents[x]);
            book[x] += book[parents[x]];
            parents[x] = root;
            return root;
        }
    }
    private static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if (px == py){
            return;
        }else{
            parents[py] = px;
            book[px] += book[py];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            String[] info = in.readLine().split(" ");
            int n = Integer.parseInt(info[0]);
            int m = Integer.parseInt(info[1]);
            for (int i = 0; i < n; i++){
                parents[i] = i;
                book[i] = Integer.parseInt(in.readLine());
            }
            for (int j = 0; j < m; j++){
                String[] friends = in.readLine().split(" ");
                int A = Integer.parseInt(friends[0]);
                int B = Integer.parseInt(friends[1]);
                union(A,B);
            }
            boolean flag = true;
            for (int k = 0; k < n; k++){
                if (book[find(k)] != 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                out.write("POSSIBLE");
            }else{
                out.write("IMPOSSIBLE");
            }
            out.newLine();
            out.flush();
            kases --;
        }

    }
}
