import java.io.BufferedReader;
import java.io.InputStreamReader;

public class f {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testC = Integer.parseInt(in.readLine());
        int cases = 1;
        while (testC >= 0){
            String[] inc = in.readLine().split(" ");
            if (inc.length == 0){
                break;
            }
            //1 - 13
            int[] nums = new int[inc.length + 1];
            for (int j = 1; j < nums.length; j ++){
                nums[j] = Integer.parseInt(inc[j-1]);
            }
            if (nums[0] < 0){
                break;
            }
            nums[0] = testC;
            String output = "";
            output += "Case " + (cases) + ":" + "\n";
            inc = in.readLine().split(" ");
            //1 - 12
            int[] required = new int[inc.length];
            for (int z = 0; z < inc.length; z++){
                required[z] = Integer.parseInt(inc[z]);
            }

            int overflow = 0;
            for (int l = 0; l < required.length; l++){
                boolean done = false;
                if ((nums[l] + overflow) < required[l]){
                    overflow += nums[l];
                }else{
                    overflow += nums[l] - required[l];
                    done = true;
                }
                if (done){
                    output += "No problem! :D\n";
                }else{
                    output += "No problem. :(\n";
                }
            }
            System.out.print(output);
            cases += 1;
            testC = Integer.parseInt(in.readLine());
        }
    }
}