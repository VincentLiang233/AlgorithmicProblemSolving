import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int startPos = 0, pos1 = 0, pos2 = 0, pos3 = 0, currentPos = 0;
        int degreePerTick = 9, totalTicks = 0;
        while(in.hasNextLine()) {
            startPos = in.nextInt();
            pos1 = in.nextInt();
            pos2 = in.nextInt();
            pos3 = in.nextInt();
            if(startPos == 0 && pos1 == 0 && pos2 == 0 && pos3 == 0) break;
            totalTicks = (startPos + 40 - pos1) % 40 +
                            (pos2 + 40 - pos1) % 40 +
                            (pos2 + 40 - pos3) % 40 +
                            3 * 40;
            System.out.println(totalTicks * degreePerTick);
        }
    }
}