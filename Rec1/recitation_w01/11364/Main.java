import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++) {

            int nStores = in.nextInt();
            List<Integer> stores = new ArrayList<Integer>();
            for(int j = 0; j < nStores; j++) {
                int location = in.nextInt();
                stores.add(location);
            }

            int minLocation = Integer.MAX_VALUE;
            int maxLocation = Integer.MIN_VALUE;

            for (Integer store : stores) {
                if(store < minLocation) {
                    minLocation = store;
                }
                if(store > maxLocation) {
                    maxLocation = store;
                }
            }

            System.out.println(2 * (maxLocation - minLocation));
        }
    }
}