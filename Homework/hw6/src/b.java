import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b {

    static private int[] parents = new int[20002];
    static private int[] distances = new int[20002];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            int enterprises = Integer.parseInt(in.readLine());
            if (enterprises < 5 || enterprises > 20000){
                continue;
            }
            for (int i = 1; i < enterprises + 1; i++){
                distances[i] = 0;
                parents[i] = i;
            }
            while (true){
                String[] info = in.readLine().split(" ");
                if (info.length < 1){
                    break;
                }
                if (info[0].equals("0")){
                    break;
                }
                else if (info[0].equals("I")){
                    int A = Integer.parseInt(info[1]);
                    int B = Integer.parseInt(info[2]);
                    parents[A] = B;
                    int k = Math.abs(A-B);
                    distances[A] = k % 1000;
                }
                else {
                    //E
                    int check = Integer.parseInt(info[1]);
                    unionFind(check);
                    out.write("" +distances[check]);
                    out.newLine();
                    out.flush();
                }
            }
            kases--;
        }
    }

     private static int unionFind(int x){
        if (parents[x] == x){
            return x;
        }else{
            int root = unionFind(parents[x]);
            distances[x] += distances[parents[x]];
            parents[x] = root;
            return root;
        }
    }



}
