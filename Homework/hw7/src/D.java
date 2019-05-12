import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            in.readLine();
            //for each case
            int num = Integer.parseInt(in.readLine());
            int[] weights = new int[105];//at most 100 people
            int sum = 0;
            for (int i = 0; i < num; i++){
                weights[i] = Integer.parseInt(in.readLine());
                sum += weights[i];
            }
            int mid = (num + 1) >>1;
            int[] dp = new int[45005]; //at most 100 * 450
            dp[0] = 1;
            for (int i = 0; i < num; i++){
                for (int j = sum; j >= weights[i]; j--){
                    dp[j] = dp[j] | (dp[j - weights[i]] << 1);  // 0-1 knapsack recurrence
                }
            }

            //find ans
            int min = 0;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < sum + 1; i++){
                for (int j = 0; j <= mid; j ++){
                    //first condition same as saying we can achieve this
                    if ((dp[i] & (1L << j)) != 0 && (Math.abs(2*j - num) <= 1)){
                        //second condition saying it satisfies max difference is 1
                        if (Math.abs(sum - 2 * i) < (max-min)){
                            max = Math.max(sum - i, i);
                            min = Math.min(sum - i, i);
                        }
                    }
                }
            }
            out.write(String.format("%d %d\n",min,max));
            if (kases != 1){
                out.newLine();
            }
            out.flush();
            kases--;
        }
    }
}
