import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class e {

    static class Task implements Comparable<Task>{
        int briefing;
        int execution;

        public Task(int b, int e){
            this.briefing = b;
            this.execution = e;
        }

        public int compareTo(Task t){
            //if we have two tasks
            //total time taken when we choose this first
            int t1 = this.briefing + t.briefing + Math.max(this.execution - t.briefing, t.execution);
            //choose t first
            int t2 =  t.briefing + this.briefing + Math.max(t.execution - this.briefing, this.execution);
            return t1 - t2;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int kcases = 1;
        while (true){
            int soldiers = sc.nextInt();
            if (soldiers == 0){
                break;
            }
            ArrayList<Task> list = new ArrayList<>(soldiers+1);
            for (int i = 0; i < soldiers; i++){
                int b = sc.nextInt();
                int e = sc.nextInt();
                Task t = new Task(b,e);
                list.add(t);
            }
            Collections.sort(list);
            int time = 0;
            int x = 0;
            for (Task t : list){
                x += t.briefing;
                time = Math.max(time, t.execution + x);
            }
            System.out.printf("Case %d: %d\n", kcases,time);
            kcases++;
        }
    }

}
