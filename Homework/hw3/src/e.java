import java.util.Scanner;

public class e {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i ++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] people = new int[(int)(Math.pow(2,n))];
            for (int j = 0; j < m; j++){
                int x = in.nextInt();
                people[x-1] = 1;
            }
            int counter = 0;
            boolean done = false;
            while (!done){
                int[] next = new int[people.length/2];
                int pointer = 0;
                int k = 0;
                while (k < people.length && pointer < next.length){
                    if (people[k] + people[k+1] == 1){
                        counter += 1;
                    }else if (people[k] == 1 && people[k+1] == 1){
                        next[pointer] = 1;
                    }
                    k += 2;
                    pointer += 1;
                }
                people = new int[next.length];
                System.arraycopy(next,0,people,0,next.length);
                if (people.length <= 1){
                    done = true;
                }
            }
            System.out.println(counter);
        }
    }
}
