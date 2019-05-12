import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String[] line = in.readLine().split(" ");
            double l = Double.parseDouble(line[0]);
            double n = Double.parseDouble(line[1]);
            double c = Double.parseDouble(line[2]);
            if (l < 0 && n < 0 && c < 0) break;
            double lprime = (1 + n * c) * l;
            double theta  = 0; // theta ~ [0,pi/2]
            double left = 0;
            double right = Math.PI /2;
            for (int i = 0; i < 100; i++){
                //precision 3 digits, 100 simulations
                theta = (left + right) /2;
                double r = l / Math.sin(theta);
                double arc = r * theta;
                if (arc < lprime){
                    //underestimated theta
                    left = theta;
                }else{
                    right = theta;
                }
            }
            l/=2;
            double r = l / Math.sin(theta);
            double ans =  r - r * Math.cos(theta);
            out.write(String.format("%.3f\n",ans));
            out.flush();
        }
    }
}