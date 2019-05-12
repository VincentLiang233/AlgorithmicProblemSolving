import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class h{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //there are in total 36 possibilities
        HashMap<List<String>,String> table = new HashMap<>();
        table.put(Arrays.asList("+x","+x"),"+x");
        table.put(Arrays.asList("+x","-x"),"-x");
        table.put(Arrays.asList("+x","+y"),"+y");
        table.put(Arrays.asList("+x","-y"),"-y");
        table.put(Arrays.asList("+x","+z"),"+z");
        table.put(Arrays.asList("+x","-z"),"-z");

        table.put(Arrays.asList("-x","+y"),"-y");
        table.put(Arrays.asList("-x","-y"),"+y");
        table.put(Arrays.asList("-x","+z"),"-z");
        table.put(Arrays.asList("-x","-z"),"+z");
        table.put(Arrays.asList("-x","-x"),"+x");
        table.put(Arrays.asList("-x","+x"),"-x");

        table.put(Arrays.asList("+y","+y"),"-x");
        table.put(Arrays.asList("+y","-y"),"+x");
        table.put(Arrays.asList("+y","+z"),"+y");
        table.put(Arrays.asList("+y","-z"),"+y");
        table.put(Arrays.asList("+y","+x"),"+y");
        table.put(Arrays.asList("+y","-x"),"+y");

        table.put(Arrays.asList("-y","+y"),"+x");
        table.put(Arrays.asList("-y","-y"),"-x");
        table.put(Arrays.asList("-y","+z"),"-y");
        table.put(Arrays.asList("-y","-z"),"-y");
        table.put(Arrays.asList("-y","-x"),"-y");
        table.put(Arrays.asList("-y","+x"),"-y");

        table.put(Arrays.asList("+z","+y"),"+z");
        table.put(Arrays.asList("+z","-y"),"+z");
        table.put(Arrays.asList("+z","+z"),"-x");
        table.put(Arrays.asList("+z","-z"),"+x");
        table.put(Arrays.asList("+z","-x"),"+z");
        table.put(Arrays.asList("+z","+x"),"+z");

        table.put(Arrays.asList("-z","+y"),"-z");
        table.put(Arrays.asList("-z","-y"),"-z");
        table.put(Arrays.asList("-z","+z"),"+x");
        table.put(Arrays.asList("-z","-z"),"-x");
        table.put(Arrays.asList("-z","-x"),"-z");
        table.put(Arrays.asList("-z","+x"),"-z");

        while (in.hasNext()){
            // 2 <= l <= 100000
            long l = in.nextInt();
            if (l <= 0) break;
            in.nextLine();
            l = l-1;
            //l should be at least 1 here
            String output = "+x";
            String[] line = in.nextLine().split(" ");
            for (int i = 0; i < l; ++i){
                // j number of decisions
                // 1 <= j <= L-1
                String dir = line[i];
                if (!dir.equals("No")){
                    output = table.get(Arrays.asList(output,dir));
                }
            }
            System.out.printf("%s\n",output);
        }

    }
}
