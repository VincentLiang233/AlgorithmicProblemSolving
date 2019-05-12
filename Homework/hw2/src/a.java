import java.util.Scanner;
import java.util.ArrayList;
public class a{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        while (in.hasNextLine()){
            int stack = in.nextInt();
            //[1,50]
            if (stack == 0){
                break;
            }

            int sum = 0;
            //two traversals
            int[] nums = new int[stack];
            for (int i = 0; i < stack; i++){
                nums[i] = in.nextInt();
                //[1,100]
                sum += nums[i];
            }

            int average = sum / stack;
            int moves = 0;
            for (int i = 0; i < stack; i++){
                if (nums[i] >= average){
                    moves += nums[i] - average;
                }
            }
            answers.add(moves);
        }
        for (int j = 0; j < answers.size(); j++) {
            System.out.println("Set #" + (j + 1));
            System.out.println("The minimum number of moves is " + answers.get(j) + ".");
            System.out.println();
        }
        in.close();
    }
}
