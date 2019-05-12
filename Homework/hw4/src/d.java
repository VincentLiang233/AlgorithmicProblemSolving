import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class d {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        while (line != null){
            int kcases = Integer.parseInt(line);
            if (kcases == 0){
                break;
            }
            ArrayList<Integer> buffer = new ArrayList<>();
            String[] lines = in.readLine().split(" ");
            for (int i = 0; i < kcases; i++){
                buffer.add(Integer.parseInt(lines[i]));
            }
            PriorityQueue<Integer> Q = new PriorityQueue<>(buffer);
            int cost = 0;
            while (!Q.isEmpty() && Q.size() > 1){
                int num1 = Q.poll();
                int num2 = Q.poll();
                cost += (num1 + num2);
                Q.offer(num1 + num2);
            }
            out.write(cost + "");
            out.newLine();
            out.flush();
            line = in.readLine();
        }
        out.close();
    }
}
