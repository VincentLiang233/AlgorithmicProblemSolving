import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    static int[] numbers = new int[12]; //at most 12 integers to be considered
    static int[] results = new int[12];
    static int total = 1001;
    static int n = 13;
    static boolean flag = true;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String[] tests = in.readLine().split(" ");
            if (tests.length == 0 || tests[1].equals("0")) break;
            flag = true;
            total = Integer.parseInt(tests[0]);
            n = Integer.parseInt(tests[1]);
            for (int i =0 ;i < n; i++){
                numbers[i] = Integer.parseInt(tests[i+2]);
            }
            out.write(String.format("Sums of %d:\n", total));
            out.flush();
            dfs(0,0,0);
            if (flag){
                out.write("NONE\n");
                out.flush();
            }
        }
    }

    private static void dfs(int subTotal, int startIndex, int endIndex){
        //start and end index for keep tracking of answers
        if (subTotal > total){
            return;
        }
        else if (subTotal == total){
            //we have found a solution
            flag = false;
            for (int i = 0; i < endIndex - 1; i++){
                //print the results list
                System.out.printf("%d+", results[i]);
            }
            System.out.printf("%d\n", results[endIndex-1]);
            return;
        }
        int last = -1;
        //subtotal < total
        for (int i = startIndex; i < n; i++){
            if (subTotal + numbers[i] > total) continue;
            if (numbers[i] != last){
                last = results[endIndex] = numbers[i];
                dfs(subTotal+numbers[i], i+1, endIndex + 1);
            }
        }
    }
}
