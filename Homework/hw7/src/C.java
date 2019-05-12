import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] inputs = in.readLine().split(" ");
            if (inputs.length == 0 || (inputs[0].equals("0") && inputs[1].equals("0"))){
                break;
            }
            boolean conflict = false;
            boolean[] tests = new boolean[1000002];
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            for (int i = 0; i < n ; i++){
                //one time tasks
                String[] oneTimeTask = in.readLine().split(" ");
                int start = Integer.parseInt(oneTimeTask[0]);
                int end = Integer.parseInt(oneTimeTask[1]);
                for (int j = start; j < end; j++){
                    if (tests[j]){
                        conflict = true;
                        break;
                    }else{
                        tests[j] = true;
                    }
                }
            }
            for (int i = 0; i < m; i++){
                String[] repeatedTask = in.readLine().split(" ");
                int start = Integer.parseInt(repeatedTask[0]);
                int end = Integer.parseInt(repeatedTask[1]);
                int interval = Integer.parseInt(repeatedTask[2]);
                int ls = start;
                int le = end;
                boolean done = false;
                while (!done && !conflict){
                    for (int k = ls; k < le; k++){
                        if (k > 1000001){
                            done = true;
                            break;
                        }else if (tests[k]){
                            conflict = true;
                            break;
                        }else{
                            tests[k] = true;
                        }
                    }
                    ls += interval;
                    le += interval;
                }
            }
            if (conflict){
                out.write("CONFLICT");
            }else{
                out.write("NO CONFLICT");
            }
            out.newLine();
            out.flush();
        }
    }
}
