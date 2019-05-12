import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class c {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> queries = new ArrayList<>();
        String line = in.readLine();
        boolean[] primes = new boolean[1001];
        int max = -1;
        while (line != null && !line.equals("")){
            String[] lines = line.split(" ");
            int N = Integer.parseInt(lines[0]);
            int C = Integer.parseInt(lines[1]);
            queries.add(N);
            queries.add(C);
            max = max > N ? max : N;
            line = in.readLine();
        }
        Arrays.fill(primes,true);
        for (int p = 2; p*p < max; p+=1){
            if (primes[p]){
                for (int s = p*p; s <= max; s += p){
                    primes[s] = false;
                }
            }
        }
        //process each query
        for (int i = 0; i <queries.size(); i+= 2){
            int N = queries.get(i);
            int C = queries.get(i+1);
            ArrayList<Integer> myPrimes = new ArrayList<>();
            for (int k = 1; k <= N; k++){
                if (primes[k]){
                    myPrimes.add(k);
                }
            }
            String ans = String.format("%d %d:", N, C);
            if (myPrimes.size() == 0){
                ans += " " + 1;
                ans += "\n";
                out.write(ans);
                out.newLine();
                out.flush();
                continue;
            }
            int start;
            int len;
            if (myPrimes.size()%2 == 0){
                len = 2*C;
                start = (myPrimes.size() - len) / 2;

            }else{
                //odd case, print 2C - 1
                len = 2 * C -1;
                start = (myPrimes.size() - len) / 2;
            }

            if (len > myPrimes.size()){
                start = 0;
                len = myPrimes.size();
            }

            for ( int l = start; l < start + len; l ++){
                ans += " " + myPrimes.get(l);
            }
            ans += "\n";
            out.write(ans);
            out.newLine();
            out.flush();
        }
        out.close();
    }
}
