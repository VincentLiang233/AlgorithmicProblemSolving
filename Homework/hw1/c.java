import java.util.Scanner;

class c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] answers = new int[cases];
        for (int i = 0; i < cases; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if ((b - a) * (c - a) <= 0) {
                answers[i] = a;
            } else if ((a - b) * (c - b) <= 0) {
                answers[i] = b;
            } else {
                answers[i] = c;
            }
        }
        for (int j = 0; j < cases; j++) {
            System.out.printf("Case %d: %d\n", j + 1, answers[j]);
        }
        in.close();
    }
}
