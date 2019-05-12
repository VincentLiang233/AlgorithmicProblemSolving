import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class c {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        while (line != null && !line.equals("") && Integer.parseInt(line) != 0) {
            int nums = Integer.parseInt(line);
            PriorityQueue<String> Q = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareToIgnoreCase(o1 + o2);
                }
            });
            String[] lines = in.readLine().split(" ");
            for (int j = 0; j < nums; j++){
                Q.add(lines[j]);
            }
            int size = Q.size();
            StringBuilder sb = new StringBuilder();
            for (int z = 0; z < size ; z++){
                sb.append(Q.poll());
            }
            out.write(sb.toString());
            out.newLine();
            out.flush();
            line = in.readLine();
        }
        out.close();
    }
}