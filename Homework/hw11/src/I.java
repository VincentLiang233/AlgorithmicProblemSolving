import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0){
            int l = Integer.parseInt(in.readLine());
            String[] original = new String[l];
            String[] target = new String[l];
            for (int i = 0; i < l; i++){
                original[i] = in.readLine();
            }
            for (int j = 0; j< l; j++){
                target[j] = in.readLine();
            }

            int i = l-1;
            int j = l-1;
            for (;i >= 0; i--){
                if (original[i].equals(target[j])){
                    j--;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (j >= 0){
                sb.append(target[j]);
                sb.append("\n");
                j--;
            }
            out.write(sb.toString());
            out.newLine();
            out.flush();
            kases--;
        }
    }
}