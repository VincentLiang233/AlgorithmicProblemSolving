import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int K = in.nextInt();
            if (K == 0) {
                break;
            } else {
                int m = in.nextInt();
                int n = in.nextInt();
                for (int i = 0; i < K; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();

                    if ((m == x) || (n == y)) {
                        System.out.println("divisa");
                    } else if (m > x) {
                        if (n > y) {
                            System.out.println("SO");
                        } else {
                            System.out.println("NO");
                        }
                    } else {
                        if (n > y) {
                            System.out.println("SE");
                        } else {
                            System.out.println("NE");
                        }

                    }
                }
            }
        }
        in.close();
    }
}
