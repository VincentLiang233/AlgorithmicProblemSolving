import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            String[] line = in.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int q = Integer.parseInt(line[1]);
            //ans should look like    101 101 101 101 ...
            StringBuilder sb = new StringBuilder();
            while (p >=2 && q >= 1){
                sb.append("101");
                p-=2;
                q-=1;
            }
            //the remaining 0s will go to the front
            //remaining 1s should be taking cared of
            if (p == 1 && q != 0){
                sb.insert(0,"1"); //prepend, learned from stackoverflow
            }else{
                for (int i = 0; i < p; i++){
                    sb.append("1");
                }
            }
            //get back the ans, get 0s to the front
            String ans = sb.reverse().toString();
            long output = 0;
            for (int i = 0; i < ans.length(); i++){
                if (ans.charAt(i) == '1'){
                    output |= (1L << i);
                }
            }
            out.write(output + "\n");
            out.flush();
            kases --;
        }
    }
}