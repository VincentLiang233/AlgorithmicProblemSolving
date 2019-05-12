
import java.util.Scanner;

public class e {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            float cost = Integer.MAX_VALUE;
            //1 <= N <= 200
            int participants = in.nextInt();
            //1 <= B <= 5000000
            int budget = in.nextInt();
            //1 <= H <= 18
            int hotels = in.nextInt();
            //1 <= W <= 13
            int weeks = in.nextInt();
            for (int i = 0; i < hotels; i ++){
                //for each hotel, get the price and available beds for each week
                //1<= p <= 10000
                float price = in.nextFloat();
                in.nextLine();
                //for each hotel,get a list of available beds
                int[] weekly = new int[weeks];
                for (int j = 0; j < weeks; j++){
                    //0 <= a <= 1000
                    weekly[j] = in.nextInt();
                }if (in.hasNextLine()){
                    in.nextLine();
                }
                //after all the information
                if (price > ((float)(budget)/(participants))){
                    //skip to next hotel
                    continue;
                }else{
                    //check if available
                    boolean flag = false;
                    for (int z = 0; z < weeks; z++){
                        if (weekly[z] >= participants){
                            flag = true;
                            break;
                        }
                    }
                    if (flag){
                        //calculate cost
                        if (cost >= price * participants){
                            cost = price * participants;
                        }
                    }else{
                        continue;
                    }
                }
            }
            if (cost != Integer.MAX_VALUE){
                System.out.println((int)cost);
            }else{
                System.out.println("stay home");
            }
        }
        in.close();
    }
}
