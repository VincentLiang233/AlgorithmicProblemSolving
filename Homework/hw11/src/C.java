import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String line = in.readLine();
            if (line == null || line.length() == 0) break;
            String s = line.replaceAll("[^a-zA-Z]+", " ").trim();
            out.write(s.split(" ").length+"\n");
            out.flush();
        }
    }
}