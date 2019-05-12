import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class E {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        //recurrence: solution[i][j] = solution[i-1][j] + solution[i-1][j-1] * (r[i] - j + 1 )
        while (true){
            String[] inputs = in.readLine().split(" ");
            if (inputs.length == 0 || (inputs[0].equals("0") && inputs[1].equals("0"))){
                break;
            }
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            if (k == 0){
                out.write("1");
                out.newLine();
                out.flush();
                continue;
            }
            if (n == 1){
                out.write(String.format("%d\n", k));
                out.flush();
                continue;
            }
            if (k > 2 * (n-1) ){
                out.write("0");
                out.newLine();
                out.flush();
                continue;
            }

            long[] blacks = new long[9]; //at most 64, so each black or white at most 8
            long[] whites = new long[9];
            for (int i = 1; i < n + 1; i++){
                whites[i] = (i%2 != 0 ? i : whites[i-1]);
            }
            for (int i = 1; i < n + 1; i++){
                blacks[i] = (i%2 != 0 ? i+1 : blacks[i-1]);
            }

            Arrays.sort(blacks);
            Arrays.sort(whites);

            //solution[i][j] represents the number of ways to store j bishops in i rows
            long[][] blackSolution = new long[9][15]; // 2(n-1) <= 15 for n <= 8
            long[][] whiteSolution = new long[9][15];
            //initial condition
            for (int i = 0; i < n + 1; i ++){
                whiteSolution[i][0] = 1;
            }
            for (int i = 1; i < k + 1 ; i ++){
                blackSolution[0][i] = 1;
            }
            //using the recurrence
            for (int i = 1; i < n+1; i++){
                for (int j = 1; j < k + 1 && j <= i; j++){
                    whiteSolution[i][j] = whiteSolution[i-1][j] + whiteSolution[i-1][j-1] * (whites[i] - j + 1);
                }
            }
            //initial condition for black
            for (int i = 0; i < n + 1; i ++){
                whiteSolution[i][0] = 1;
            }
            for (int i = 1; i < k + 1 ; i ++){
                blackSolution[0][i] = 1;
            }
            //using the recurrence
            for (int i = 1; i < n+1; i++){
                for (int j = 1; j < k + 1 && j <= i; j++){
                    blackSolution[i][j] = blackSolution[i-1][j] + blackSolution[i-1][j-1] * (blacks[i] - j + 1);
                }
            }
            long total = 0;
            for (int i = 0; i < k + 1; i++){
                total += whiteSolution[n][i] + blackSolution[n-1][k-i];
            }
            out.write(""+total);
            out.newLine();
            out.flush();
        }
    }
}
