import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[30002]; // at most 300 bucks
        //coins: 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5
        int[] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000};
        while(true){
            double n = Double.parseDouble(in.readLine().replace(" ",""));
            if (n == 0.00) break;
            int kn = (int) (n*100 + 0.5); //just notice that there's a precession issue,
            // dk why, but it will work (from piazza)

            Arrays.fill(dp,0L);
            dp[0] = 1; // s.t. dp[5] = 1, dp[10] = 1...etc.
            for (int coin: coins){
                for (int i = coin; i<= kn; i++){
                    dp[i] += dp[i-coin];
                }
            }
            long ans = dp[kn];
            out.write(String.format("%6.2f%17d\n",n,ans));
            out.flush();
        }

    }
}
