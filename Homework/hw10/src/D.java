import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String lines = in.readLine();
            if (lines == null || lines.equals("")) break;

            String[] line = lines.split(" ");
            if (line.length == 0) break;

            //assume the array is at least of length 1
            BigInteger[] dp = new BigInteger[line.length -1];
            for (int i = 0; i< dp.length; i++){
                dp[i] = new BigInteger(line[i]);
            }
            BigInteger zero = new BigInteger("0");
            BigInteger min = new BigInteger(line[0]);
            BigInteger max = new BigInteger(line[0]);
            BigInteger ans = new BigInteger(line[0]);

            for (int i = 1; i< line.length -1; i++){
                //go through the big ints array
                if (dp[i].compareTo(zero) < 0){ // < 0
                    //swap
                    BigInteger temp = new BigInteger(min.toString());
                    min = new BigInteger(max.toString());
                    max = new BigInteger(temp.toString());
                }
                if (dp[i].compareTo(max.multiply(dp[i])) < 0){
                    max = max.multiply(dp[i]);
                }else{
                    max = dp[i];
                }

                if (dp[i].compareTo(min.multiply(dp[i])) > 0){
                    min = min.multiply(dp[i]);
                }else{
                    min = dp[i];
                }

                if (max.compareTo(ans) > 0){
                    ans = max;
                }
            }
            out.write(ans.toString() + "\n");
            out.flush();
        }

    }
}
