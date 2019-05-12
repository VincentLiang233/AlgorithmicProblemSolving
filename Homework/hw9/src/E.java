import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        while(true){
            //1000 digits!
            BigInteger k = new BigInteger(in.readLine());
            if (k.equals(BigInteger.valueOf(-1))) break;
            //some shortcuts
            StringBuilder sb = new StringBuilder();
            if (k.equals(zero)) sb.append("10");
            if (k.equals(one)) sb.append("11");
            boolean ans = true;
            while(k.compareTo(BigInteger.ONE)>0){
                boolean flag = false;
                for (int i = 9; i > 1; i--){
                    //divide through 9 to 2, 1 doesn't matter
                    BigInteger j = BigInteger.valueOf(i);
                    if (k.mod(j).equals(zero)){
                        //divisible, then prepend i to make sure the largest one stays in the back
                        sb.insert(0,i);
                        k = k.divide(j);
                        flag = true;
                        break;
                    }
                }
                if (!flag){ // prime factor
                    ans = false;
                    break;
                }
            }
            if (!ans){
                out.write("There is no such number.\n");
            }else{
                String output = sb.toString();
                if (output.length() == 1){
                    output = "1" + output;
                }
                out.write(output + "\n");
            }
            out.flush();
        }

    }
}
