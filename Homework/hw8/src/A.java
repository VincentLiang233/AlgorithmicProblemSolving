import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        int k = 1;
        while (kases >0){
            int n = Integer.parseInt(in.readLine());
            String[] line = in.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(line[i]);
            }
            int ans ;
            if (n == 1){
                ans = nums[0];
            }else{
                int[] diffs = new int[n-1];
                for (int i = 0; i < n-1; i++){
                    diffs[i] = nums[i+1] - nums[i];
                }
                ans = -1;
                for (int i = n-1; i > 0; i--){
                    if (diffs[i-1] == ans){
                        ans +=1;
                    }else{
                        ans = Math.max(ans,diffs[i-1]);
                    }
                }
                //last step case
                if (nums[0] == ans) ans += 1;
                else ans = Math.max(ans, nums[0]);
            }

            out.write(String.format("Case %d: %d\n", k, ans));
            out.flush();
            k++;
            kases--;
        }
    }
}