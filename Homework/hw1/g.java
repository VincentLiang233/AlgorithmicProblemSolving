import java.util.ArrayList;
import java.util.Scanner;

public class g {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> cases = new ArrayList<>();
        while (in.hasNextLine()){
            int requirements = in.nextInt();
            //0 < n <= 1000
            int proposals = in.nextInt();
            //number of proposals, maybe 0
            //NOTE !! NEW LINE !!
            if (in.hasNextLine()){
                in.nextLine();
            }
            if ((requirements == 0) && (proposals == 0)){
                break;
            }
            if (proposals == 0){
                break;
            }
            String answers = "";
            //skip through the next few lines
            for (int i = 0; i < requirements; i ++){
                in.nextLine();
            }
            double winning = Integer.MAX_VALUE;
            double winningMet = Integer.MIN_VALUE;
            for (int i = 0 ; i < proposals; i ++){
                float price ;
                //for each competitors
                String competitor = in.nextLine();
                if (in.hasNextFloat()){
                    price = in.nextFloat();
                }else{
                    in.nextLine();
                    price = in.nextFloat();
                }
                //0 <= p <= ?
                int met = in.nextInt();
                //0 <= met <= requirements
                //NOTE !! NEW LINE !!
                if (in.hasNextLine()){
                    in.nextLine();
                }
                for (int z = 0; z < met; z++){
                    //skip a few more lines
                    in.nextLine();
                }
                double compliance = met * 1.0 / requirements;
                if (compliance > winningMet){
                    winningMet = compliance;
                    winning = price;
                    answers = competitor;
                }else if (compliance == winningMet){
                    if (price < winning){
                        winning = price;
                        answers = competitor;
                    }
                    else{
                        //nothing changes
                    }
                }
                else{
                    continue;
                }
            }
            //after the result has been recorded
            cases.add(answers);
        }
        in.close();
        //after no more input
        for (int i = 0;i < cases.size(); i ++){
            if (i != cases.size()-1){
                System.out.printf("RFP #%d\n",i+1);
                System.out.printf("%s\n",cases.get(i));
                System.out.println();
            }else{
                System.out.printf("RFP #%d\n",i+1);
                System.out.printf("%s\n",cases.get(i));
            }
        }
    }
}
