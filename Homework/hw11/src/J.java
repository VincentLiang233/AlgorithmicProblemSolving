import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int n = in.nextInt();
            if (n == 0) break;
            int[] w = new int[n];
            for (int i = 0; i< w.length; i++){
                w[i] = in.nextInt();
            }
            //minimize the total number of bags
            //and also the pieces within a bag
            Arrays.sort(w); // weights sort
            int max = 0;
            int count = 1;
            for (int i = 1; i< w.length; i++){
                if (w[i] == w[i-1]){
                    count ++;
                }else{
                    count = 1;
                }
                max = Math.max(count,max);
            }
            if (max == 0) max = 1;
            //we need max number of bags for sure
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%d\n", max));
            for (int i = 0; i< max; i++){
                //each bag, max number of items !
                for (int j = i; j< w.length; j+= max){
                    if (j != i) sb.append(" ");
                    sb.append(String.format("%d", w[j]));
                }
                sb.append("\n");
            }
            sb.append("\n");
            out.write(sb.toString());
            out.flush();
        }
    }
}