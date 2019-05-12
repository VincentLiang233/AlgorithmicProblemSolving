import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class b {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int counter = 1;
        ArrayList<Integer> list = new ArrayList<>();
        String line = in.readLine();
        while (line != null && !line.equals("") && !line.equals(" ")){
            line = line.trim();
            list.add(Integer.parseInt(line));//leading or trailing spaces removed?
            Collections.sort(list);
            if (counter%2 == 0){
                //even num
                if (list.size() == 2){
                    int value = (list.get(0) + list.get(1))/2;
                    out.write(value + "");
                }
                else{
                    int first = list.get(list.size()/2);
                    int next = list.get(list.size()/2 - 1);
                    int value = (first + next)/2;
                    out.write(value + "");
                }
            }else{
                if (list.size() == 1){
                    out.write(list.get(0) + "");
                }else{
                    int index = list.size()/2;
                    int value = list.get(index);
                    out.write(value + "");
                }
            }
            out.newLine();
            out.flush();
            counter += 1;
            line = in.readLine();
        }
    }
}