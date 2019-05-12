import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class b {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kcases = Integer.parseInt(in.readLine());
        boolean[] primes = new boolean[1000001]; //all false
        ArrayList<Integer> queries = new ArrayList<>();
        int max = -1;
        while (kcases > 0){
            String[] line = in.readLine().split(" ");
            int lower = Integer.parseInt(line[0]);
            int higher = Integer.parseInt(line[1]);
            queries.add(lower);
            queries.add(higher);
            max = (higher > max) ? higher : max;
            kcases--;
        }
        //generate all primes up to max
        Arrays.fill(primes,true);
        for (int p = 2; p*p < max; p+=1){
            if (primes[p]){
                for (int s = p*p; s <= max; s += p){
                    primes[s] = false;
                }
            }
        }
        //search answer for each pair
        for (int i = 0; i < queries.size(); i+=2){
            int lower = queries.get(i);
            int higher = queries.get(i+1);
            if (lower == higher){
                out.write("No jumping champion");
                out.newLine();
                out.flush();
                continue;
            }
            HashMap<Integer, Integer> frequency = new HashMap<>();
            ArrayList<Integer> diffs = new ArrayList<>();
            int previous = 0;
            int count = 0;
            for (int j = lower; j <= higher; j ++){
                if (j != 0 && j != 1){
                    if (primes[j]){
                        //if j is a prime
                        count += 1;
                        if (previous != 0){
                            //if we have previous prime
                            diffs.add(j-previous);
                            if (!frequency.containsKey(j-previous)){
                                frequency.put(j-previous,1);
                            }else{
                                frequency.replace(j-previous,(frequency.get(j-previous) + 1));
                            }
                            previous = j;
                        }else{
                            //otherwise just mark our real starting point
                            previous = j;
                        }
                    }
                }
            }
            if (count < 2){
                out.write("No jumping champion");
                out.newLine();
                out.flush();
                continue;
            }
            //find the max occurring frequency
            int answerK = -1;
            int answerV = -1;
            for (Map.Entry<Integer, Integer> entry: frequency.entrySet()){
                if (entry.getValue() > answerV){
                    answerK = entry.getKey();
                    answerV = entry.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> entry: frequency.entrySet()){
                if (entry.getValue() == answerV && entry.getKey() != answerK){
                    answerK = -1;
                }
            }

            if (answerK == -1){
                out.write("No jumping champion");
                out.newLine();
                out.flush();
            }
            else{
                out.write("The jumping champion is " + answerK);
                out.newLine();
                out.flush();
            }
        }
        out.close();
    }
}
