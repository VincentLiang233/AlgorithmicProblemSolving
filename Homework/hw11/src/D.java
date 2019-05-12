import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class D {
    static boolean[] primes = new boolean[10000100];
    static String ans;
    static ArrayList<Integer> primeTable = new ArrayList<>(10000001);

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(primes,true);
        primes[1] = false;
        primes[0] = false;
        int k = 10000001;
        for (int p = 2; p*p < k; p++){
            if (primes[p]){
                for (int s = p*p; s <= k; s += p){
                    primes[s] = false;
                }
            }
        }
        for (int i = 2; i <= k; i++){
            if (primes[i]) primeTable.add(i);
        }
        //primes table generated
        while(true){
            ans = "";
            String line = in.readLine();
            if (line == null || line.length() == 0) break;
            int n = Integer.parseInt(line);
            //哥德巴赫猜想
            if (n < 8) ans = "Impossible.";
            else if (n%2 == 0){
                //even case, ans = 2 + 2 + Goldbach(x-4)
                String s = GoldbachConjecture(n-4);
                if (!s.equals("")){
                    ans += "2 2";
                    ans += s;
                }else{
                    ans = "Impossible.";
                }
            }else{
                //odd case ans = 2 + 3 + Goldbach(x-5)
                String s = GoldbachConjecture(n-5);
                if (!s.equals("")){
                    ans += "2 3";
                    ans += s;
                }else{
                    ans = "Impossible.";
                }
            }
            ans += "\n";
            out.write(ans);
            out.flush();

        }
    }

    private static String GoldbachConjecture(int n){
        for (int i = 0; primeTable.get(i) <= n/2; i++){
            int diff = n - primeTable.get(i);
            if (primes[diff]){
                return (String.format(" %s %s", primeTable.get(i)+"",diff+""));
            }
        }
        return "";
    }
}