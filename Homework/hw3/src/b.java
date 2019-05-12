import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class b {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int kcases = Integer.parseInt(in.readLine());
        for (int i = 0; i < kcases; i ++){
            String[] line = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            // 1<= n,m <= 1000
            //n is the number of patients
            //m is the number of doctors offices
            ArrayList<PriorityQueue<Patient>> Q = new ArrayList<>();
            ArrayList<LinkedList<Integer>> q = new ArrayList<>();
            for (int j = 0; j < n; j ++){
                String[] lines = in.readLine().split(" ");
                int t = Integer.parseInt(lines[0]);
                int k = Integer.parseInt(lines[1]);
                Patient p = new Patient(t,j);
                for (int z = 0; z < k; z++){
                    LinkedList<Integer> temp = new LinkedList<>();
                    temp.push(Integer.parseInt(lines[z+2]));
                    q.add(j,temp);
                }
                PriorityQueue<Patient> temp = new PriorityQueue<>();
                temp.add(p);
            }
            boolean flag = false;
            int cur = 0;
            while (!flag){
                flag = true;
                for (int s = 0; s < m; s++){
                    if (!Q.isEmpty()){
                        flag = true;
                        PriorityQueue<Patient> temp = Q.get(i);
                        Patient p = temp.peek();
                        if (p.time > cur){
                            continue;
                        }
                        else{
                            temp.poll();
                            LinkedList<Integer> temp2 = q.get(p.id);
                            temp2.pop();
                            if (!temp2.isEmpty()){
                                p.time = cur + 1;
                                Q.get(temp2.peekFirst()).add(p);
                            }
                        }
                    }
                }
                cur += 1;
            }
            System.out.println(cur);
        }
    }

     static class Patient{
        int time;
        int id;
        Patient(int time, int id){
            this.time = time;
            this.id = id;
        }
    }
}
