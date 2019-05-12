import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int routes = Integer.parseInt(in.readLine().replace(" ",""));
        int kcases = 1;
        while (routes > 0){
            int stops = Integer.parseInt(in.readLine().replace(" ",""));
            //find maxSubArr
            int currentMax = 0;
            int globalMax = 0;
            int start = 0;
            int end = 0;
            int temp = 1; //previous max starts at temp

            //for special requirement
            int len = 0; //keep track of longest cycle rides
            for (int i = 1; i < stops; i++){
                int cur = Integer.parseInt(in.readLine().replace(" ",""));
                currentMax += cur;
                if (currentMax > globalMax || (currentMax == globalMax && len < (i - temp))){
                    //update global and record start
                    globalMax = currentMax;
                    start = temp ;
                    end = i;
                    len = i - temp;
                }else if (currentMax < 0){
                    //start looking from next element and reset currentMax
                    temp = i + 1;
                    currentMax = 0;
                }
            }
            if (globalMax == 0){
                //nothing got updated
                out.write(String.format("Route %d has no nice parts\n",kcases));
            }else{
                end += 1;
                out.write(String.format("The nicest part of route %d is between stops %d and %d\n", kcases, start, end));
            }

            out.flush();
            kcases ++;
            routes --;
        }


    }
}
