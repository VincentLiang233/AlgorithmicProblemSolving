import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            int[] vals = Arrays.stream(line.split("\\s+")).mapToInt(Integer::valueOf).toArray();
            Stack<Integer> matrioshkas = new Stack<Integer>();
            Stack<Integer> sizes = new Stack<Integer>();
            boolean valid = true;
            for(int val : vals) {
                if(val < 0) {
                    // new matrioshka
                    val = -val;
                    if(matrioshkas.empty() || (matrioshkas.peek() > val && sizes.peek() > val)) {
                        // can put in the new matrioshka
                        matrioshkas.push(val);
                        sizes.push(val);
                    } else {
                        // cannot put in the new matrioshka
                        valid = false;
                        break;
                    }
                } else {
                    // closing a matrioshka
                    if(!matrioshkas.empty() && val == matrioshkas.peek()) {
                        // same matrioshka
                        int top = matrioshkas.peek();
                        matrioshkas.pop();
                        sizes.pop();
                        if(!sizes.empty()) {
                            sizes.push(sizes.pop() - top);
                        }
                    } else {
                        // different matrioshka
                        valid = false;
                        break;
                    }
                }
            }
            valid &= matrioshkas.empty(); // all matrioshkas should be closed
            if(valid) {
                System.out.println(":-) Matrioshka!");
            } else {
                System.out.println(":-( Try again.");
            }
        }
    }
}