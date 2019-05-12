import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class e {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int i = 0 ; i < cases ;i ++){
            String[] incoming = in.readLine().split(" ");
            int jobs = Integer.parseInt(incoming[0]);
            int pos = Integer.parseInt(incoming[1]);
            ArrayList<Integer> priorities = new ArrayList<>();
            incoming = in.readLine().split(" ");
            for (int j = 0; j < jobs; j++){
                priorities.add(Integer.parseInt(incoming[j]));
            }
            int output = 0;
            while (true){
                //whether current job gets done, pointer should be the other way around tho
                boolean done = false;
                int cur = priorities.get(0);
                for (int z = 1; z < priorities.size(); z++){
                    if (priorities.get(z) > cur) {
                        done = true;
                        break;
                    }
                }
                if (!done){
                    if (pos == 0){
                        break;
                    }else{
                        output += 1;
                        priorities.remove(0);
                    }

                }else{
                    int temp = priorities.get(0);
                    priorities.remove(0);
                    priorities.add(temp);
                }
                //else
                pos --;
                if (pos < 0){
                    pos = priorities.size() - 1;
                }
            }
            System.out.printf("%d\n",output + 1);
        }
    }
}
