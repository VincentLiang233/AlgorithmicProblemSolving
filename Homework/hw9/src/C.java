import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int kases = in.nextInt();
            if (kases == 0) break;
            int[] nums = new int[kases];
            for (int i = 0; i < kases ;i++){
                nums[i] = in.nextInt();
            }
            int[] dp = new int[kases]; //try to use a different approach to A
            dp[0] = Math.max(0,nums[0]);
            //dp[i] is the maximum streak we can get to at ith element of nums
            for (int i = 1; i < kases; i++){
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            int ans = -1;
            for(int i = 0; i < dp.length; i++){
                ans = Math.max(ans,dp[i]);
            }

            if (ans> 0){
                out.write(String.format("The maximum winning streak is %d.\n",ans));
            }else{
                out.write("Losing streak.\n");
            }
            out.flush();
        }

    }
}
