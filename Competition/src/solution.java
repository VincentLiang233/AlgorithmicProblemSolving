import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Point> arr = new ArrayList<>();
        String line = in.readLine();
        int kcases = Integer.parseInt(line);
        for (int i =0; i < kcases; i++) {
            String[] lines = in.readLine().split(" ");
            Point l1 = new Point();
            l1.x = Integer.parseInt(lines[0]);
            l1.y = Integer.parseInt(lines[1]);
            Point r1 = new Point();
            r1.x = Integer.parseInt(lines[2]);
            r1.y = Integer.parseInt(lines[3]);
            arr.add(l1);
            arr.add(r1);
        }
        int output = 0;
        for (int j = 0; j < arr.size(); j+=2) {
            //two points construct a rectangle
            Point l1 = arr.get(j);
            Point r2 = arr.get(j+1);
            Point r1 = new Point();
            Point l2 = new Point();
            r1.x = r2.x;
            r1.y = l1.y;
            l2.x = l1.x;
            l2.y = r2.y;
            if (doOverlap(l1,r1,l2,r2)){
                output = 1;
            }
        }
        out.write(Integer.toString(output));
        out.flush();
        out.close();
    }

    private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }
        if (l1.y < r2.y || l2.y < r1.y) {
            return false;
        }
        return true;
    }

    static class Point{
        int x,y;
    }
}