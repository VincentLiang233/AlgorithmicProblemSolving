import java.util.Scanner;

public class f {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for ( int i = 0; i < cases; i ++){
            int max = Integer.MIN_VALUE;
            int leading = in.nextInt();
            for (int j = 0; j < leading; j++){
                int next = in.nextInt();
                max = Math.max(next,max);
            }
            System.out.printf("Case %d: %d\n", i + 1, max);
        }
    }
}
