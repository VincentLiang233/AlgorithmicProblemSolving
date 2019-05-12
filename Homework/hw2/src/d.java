import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class d {
    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int i = 0; i < cases; i++) {
            String[] inc = in.readLine().split(" ");
            int n = Integer.parseInt(inc[0]);
            int t = Integer.parseInt(inc[1]);
            int m = Integer.parseInt(inc[2]);
            ArrayDeque<Car> left = new ArrayDeque<>();
            ArrayDeque<Car> right = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                String[] line = in.readLine().split(" ");
                int time = Integer.parseInt(line[0]);
                String side = line[1];
                if (side.equals("left")) {
                    left.add(new Car(time, j));
                } else {
                    right.add(new Car(time, j));
                }
            }
            int[] answer = new int[m];
            int currentTime = 0;
            String side = "left";
            while (!(left.isEmpty() && right.isEmpty())) {
                ArrayDeque<Car> first;
                ArrayDeque<Car> second;
                if (side.equals("left")) {
                    first = left;
                    second = right;
                } else {
                    first = right;
                    second = left;
                }
                int load = 0;
                while (!first.isEmpty()){
                    if (load < n){
                        if (first.peek().time <= currentTime){
                            load += 1;
                            answer[first.peek().order] = currentTime + t;
                            first.pop();
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                //when do we go to the other side?
                if (load > 0){
                    currentTime += t;
                    side = side.equals("left") ? "right" : "left";
                }
                else{
                    if (first.isEmpty()){
                        if (!second.isEmpty()){
                            if (second.peek().time > currentTime){
                                currentTime = second.peek().time + t;
                            }else{
                                currentTime += t;
                            }
                            side = side.equals("left") ? "right" : "left";
                        }
                    }
                    else if (second.isEmpty()){
                        currentTime = first.peek().time;
                    }else {
                        //nothing empty here
                        if (first.peek().time <= second.peek().time){
                            currentTime = first.peek().time;
                        }else {
                            if (second.peek().time > currentTime){
                                currentTime = second.peek().time + t;
                            }else{
                                currentTime += t;
                            }
                            side = side.equals("left") ? "right" : "left";
                        }
                    }
                }
            }
            for (int k = 0; k < m; k++) {
                System.out.println(answer[k]);
            }
            if (i != cases - 1) {
                System.out.println();
            }
        }
    }
    private static class Car {
        int time;
        int order;
        public Car(int time, int order) {
            this.time = time;
            this.order = order;
        }
    }
}

