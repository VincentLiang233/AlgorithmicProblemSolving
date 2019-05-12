import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class a {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kcases = Integer.parseInt(in.readLine());
        int counter = 1;
        while (kcases > 0){
            String[] nums = in.readLine().split(" ");
            //assumed nums.length >= 1
            int numOfCases = Integer.parseInt(nums[0]);
            int[] process = new int[numOfCases];
            for (int i = 0; i < process.length; i++){
                process[i] = Integer.parseInt(nums[i+1]);
            }
            String output = String.format("Case %d: %d",counter,process[(numOfCases-1)/2]);
            out.write(output);
            out.newLine();
            out.flush();
            counter += 1;
            kcases --;
        }
        out.close();
    }
}
