import java.util.ArrayList;
import java.util.Scanner;

public class d{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        while(in.hasNext()){
            //first 4 pieces of information
            int terms = in.nextInt();
            float down = in.nextFloat();
            float amount = in.nextFloat();
            int queries = in.nextInt();
            if ((terms < 0 || down < 0) || (amount < 0 || queries <= 0)){
                break;
            }
            if (terms == 0 || amount == 0){
                answers.add(0);
                break;
            }
            //initial loan, monthly loan and value calculation
            float loan = amount;
            float value = amount + down;
            float monthly = loan/terms;
            float[] table = new float[terms+1];
            //getting all the available inputs
            for (int i = 0; i< queries; i ++){
                int month = in.nextInt();
                float discount = in.nextFloat();
                table[month] = discount;
            }
            //calculate the rest of the table
            float temp = 0;
            for (int i = 0; i < terms+1; i ++){
                if (table[i] != 0){
                    temp = table[i];
                }else{
                    table[i] = temp;
                }
            }
            //value immediately drops at month 0
            value = value * (1-table[0]);
            //find the answers using the table
            for (int i = 1; i < terms + 1; i++){
                if (value > loan){
                    answers.add(i-1);
                    break;
                }
                if (i == terms){
                    //corner case
                    answers.add(terms);
                    break;
                }
                value = value * (1-table[i]);
                loan -= monthly;
            }
        }

        //after all the answers are collected
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i) != 1){
                System.out.printf("%d months\n",answers.get(i));
            }else{
                System.out.printf("%d month\n",answers.get(i));
            }
        }
    }
}
