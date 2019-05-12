import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        int counter = 1;
        while (line != null && !line.equals("") && !line.equals(" ")){
            int nums = Integer.parseInt(line);
            if (nums == 0){ break; }
            int[] years = new int[10000];
            int min = 0;
            for (int i =0; i < nums; i++){
                //use BitSet to rule out possible output
                String[] lines = in.readLine().split(" ");
                int y = Integer.parseInt(lines[0]);
                int a = Integer.parseInt(lines[1]);
                int b = Integer.parseInt(lines[2]);
                int flag1 = a;
                int flag2 = a;
                for (int k = flag1; k < 10000; k++){
                    if (flag2 == b) {
                        flag2 = a;
                    }
                    if (flag2 == y){
                        years[flag1] ++;
                    }
                    flag1 += 1;
                    flag2 += 1;
                }
                min = Math.max(min,a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Case #%d:\n",counter));
            int output = -1;
            for (int j = min; j < 10000; j ++){
                if (years[j] == nums){
                    output = j;
                    break;
                }
            }
            if (output != -1){
                sb.append(String.format("The actual year is %d.\n",output));
            }else{
                sb.append("Unknown bugs detected.\n");
            }
            sb.append("\n");
            out.write(sb.toString());
            out.flush();
            counter += 1;
            line = in.readLine();
        }
    }
}