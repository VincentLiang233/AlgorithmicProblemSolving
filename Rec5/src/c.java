import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

public class c {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        while (line != null && !line.equals("")){
            //for each case
            Stack<Integer> st = new Stack<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            ArrayDeque<Integer> ad = new ArrayDeque<>();
            int nums = Integer.parseInt(line);
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;
            for (int i = 0; i < nums; i++){
                String[] lines = in.readLine().split(" ");
                int num1 = Integer.parseInt(lines[0]);
                int num2 = Integer.parseInt(lines[1]);
                if (num1 == 1){
                    //1 push
                    st.push(Integer.parseInt(lines[1]));
                    pq.add(Integer.parseInt(lines[1]));
                    ad.addLast(Integer.parseInt(lines[1]));
                }else{
                    //2 pop
                    int sto = st.pop();
                    int pdo = pq.peek();
                    int ado = ad.pollFirst();
                    int outp = Integer.parseInt(lines[1]);
                    if (sto == outp){
                        flag1 = false;
                    }
                    if (pdo == outp){
                        flag2 = false;
                    }
                    if (ado == outp){
                        flag3 = false;
                    }
                }
            }
            if (flag1 && !flag2 && !flag3){
                out.write("stack");
            }else if (!flag1 && flag2 && !flag3){
                out.write("priority queue");
            }else if (!flag1 && !flag2 && flag3){
                out.write("queue");
            }else if (flag1 || flag2 || flag3){
                out.write("not sure");
            }else{
                out.write("impossible");
            }
            out.newLine();
            out.flush();
            line = in.readLine();
        }
    }
}
