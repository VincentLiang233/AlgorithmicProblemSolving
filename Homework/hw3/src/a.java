
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class a {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int kcases = Integer.parseInt(in.readLine());
        while (kcases> 0){
            int days = Integer.parseInt(in.readLine());
            int parties = Integer.parseInt(in.readLine());
            int[] harDays = new int[parties];
            for (int i = 0; i < parties; i++){
                harDays[i] = Integer.parseInt(in.readLine());
            }
            int counter = 0;
            for (int j = 0; j < days; j ++){
                if (!(j%7 == 5) && !(j%7 == 6)){
                    for (int z = 0; z < harDays.length; z++){
                        if ((j+1)%harDays[z] == 0){
                            counter += 1;
                            break;
                        }
                    }
                }
            }
            System.out.println(counter);
            kcases --;
        }
    }
}
