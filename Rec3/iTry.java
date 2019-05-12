import java.io.BufferedReader;
import java.io.InputStreamReader;
public class iTry{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        while (line != null){
            int k = Integer.parseInt(line);
            int ks = Integer.reverseBytes(k);
            System.out.printf("%d converts to %d\n",k,ks);
            line = in.readLine();
        }
    }
}
