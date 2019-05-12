import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class e {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfCases = Integer.parseInt(in.readLine());
        while (numOfCases > 0){
            int kcases = Integer.parseInt(in.readLine());
            HashMap<Integer,Integer> map = new HashMap<>();
            int ans = 0;
            int last = 0;
            for (int k = 0; k < kcases; k++){
                int num = Integer.parseInt(in.readLine());
                if (!map.containsKey(num)){//if we have never seen the num
                    map.put(num,k);
                    ans = ans > (k-last + 1) ? ans : (k-last + 1);
                }else{
                    //if we have seen this before
                    int pos = map.get(num);
                    if (pos >= last){
                        last = pos + 1;//updating our new starting point,
                        // all previous indexes will not give best answer
                    }
                    ans = ans > (k-last + 1)? ans : (k-last + 1);
                    map.put(num,k);//update the map
                }
            }
            out.write(Integer.toString(ans));
            out.newLine();
            out.flush();
            numOfCases --;
        }

    }
}