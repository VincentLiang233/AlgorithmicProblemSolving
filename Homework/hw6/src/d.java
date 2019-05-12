import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class d {

    static class Problem implements Comparable<Problem>{
        public int s;
        public int g;

        public Problem(int S,int G){
            this.s = S;
            this.g = G;
        }
        public int compareTo(Problem b){
            int k1 = this.s + Math.max(this.g , b.s) + b.g; //for each problem, should we start with this?
            int k2 = b.s + Math.max(b.g, this.s) + this.g; // or this?
            return k1 - k2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String line = in.readLine();
            if (line == null || line.equals("")){
                break;
            }
            int l = Integer.parseInt(line);
            String[] Si = in.readLine().split(" ");
            String[] Gi = in.readLine().split(" ");
            ArrayList<Problem> problems = new ArrayList<>(l+1);
            for (int i =0; i< l; i++){
                int S = Integer.parseInt(Si[i]);
                int G = Integer.parseInt(Gi[i]);
                problems.add(new Problem(S,G));
            }
            Collections.sort(problems);
            int t1 = 0;
            int t2 = 0;
            for (Problem p : problems){
                t1 += p.s;
                if (t2 - p.s >= 0){
                    t2 = p.g + (t2 - p.s);
                }else{
                    t2 = p.g;
                }
            }
            t1 += t2;
            out.write( t1+"");
            out.newLine();
            out.flush();
        }

    }
}
