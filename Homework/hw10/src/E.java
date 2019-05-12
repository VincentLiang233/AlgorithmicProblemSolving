import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E {
    private static String s = " ";
    private static StringBuilder output;
    private static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            s = in.readLine();
            if (s == null || s.length() == 0) break;

            output = new StringBuilder();
            //dp[i][j] is the minimum number of characters we need to make s.substring(i,j+1) a palindrome
            for (int i = 0; i< s.length(); i++){
                for (int j = 0; j < s.length(); j++){
                    dp[i][j] = -1;
                }
            }

            int left = 0;
            int right = s.length() - 1;
            int ans = solve(left,right);
            output(left,right);
            out.write(String.format("%d %s\n", ans, output.toString()));
            out.flush();
        }
    }

    private static void output(int i , int j){
        if (i > j){
            return;
        }
        if (i == j){
            output.append(s.charAt(i));
            return;
        }
        if (s.charAt(i) == s.charAt(j)){
            output.append(s.charAt(i));
            output(i+1,j-1);
            output.append(s.charAt(i));
        }else if(dp[i+1][j] + 1 == dp[i][j]){
            output.append(s.charAt(i));
            output(i+1,j);
            output.append(s.charAt(i));
        }else{
            output.append(s.charAt(j));
            output(i,j-1);
            output.append(s.charAt(j));
        }
    }
    
    private static int solve(int i , int j){
        if (i >= j){
            dp[i][j] = 0;
            return 0;
        }
        if (dp[i][j] >= 0){
            return dp[i][j];
        }
        else{
            if (s.charAt(i) == s.charAt(j)){
                dp[i][j] = solve(i+1, j-1);
            }else{
                int temp1 = solve(i+1,j);
                int temp2 = solve(i,j-1);
                if (temp1 <= temp2){
                    dp[i][j] = temp1 + 1;
                }else{
                    dp[i][j] = temp2 + 1;
                }
            }
            return dp[i][j];
        }
    }
}
