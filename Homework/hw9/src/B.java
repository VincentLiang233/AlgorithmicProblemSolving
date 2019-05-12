import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        int[] dp = new int[20001]; // at most 100 bucks item
        while (kases > 0){
            int price = Integer.parseInt(in.readLine());
            int coins = Integer.parseInt(in.readLine());
            int[] myCoins = new int[coins];
            for (int i = 0 ; i < coins; i++){
                myCoins[i] = Integer.parseInt(in.readLine());
            }
            //initialization
            dp[0] = 0;
            for (int i = 1; i < 20001; i++){
                dp[i] = Integer.MAX_VALUE;
            }

            //for every coin
            for (int coinVal : myCoins){
                //dp[j] is the minimum of coins to make value j
                for (int j = 20000 - coinVal; j >= 0; j--){
                    if (dp[j] != Integer.MAX_VALUE){
                        dp[j + coinVal] = Math.min(dp[j]+1, dp[j + coinVal]);
                    }
                }
            }
            //get the minimum value to make the price
            int index = price;
            int ans = Integer.MAX_VALUE;
            for (int i = price; i < 20001; i++){
                if (dp[i] != Integer.MAX_VALUE && dp[i] < ans){
                    index = i;
                    ans = dp[i];
                    break;
                }
            }
            out.write(String.format("%d %d\n", index, ans));
            out.flush();
            kases--;
        }

    }
}
