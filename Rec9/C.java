import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class C{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            int n = Integer.parseInt(in.readLine());
            String[] line = in.readLine().split(" ");
            PriorityQueue<Integer> list = new PriorityQueue<>((a,b) -> b-a);
            for (int i = 0; i< n; i++){
                list.add(Integer.parseInt(line[i]));
            }
            int ans = 0;
            for (int i = 0; i< n; i++){
                if (!list.isEmpty()){
                    list.poll();
                    list.poll();
                    ans += list.poll();
                }
                else{
                    break;
                }
            }
            out.write(""+ans);
            out.newLine();
            out.flush();
            kases --;
        }
    }
}
