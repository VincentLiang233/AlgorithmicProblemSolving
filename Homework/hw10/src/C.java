import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class C {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int kases = Integer.parseInt(in.readLine());
        while (kases > 0) {
            String[] line = in.readLine().split(" ");
            int m = Integer.parseInt(line[0]); // m books
            int k = Integer.parseInt(line[1]); // k scribes

            pages = new int[m];
            String[] line2 = in.readLine().split(" ");
            long mid, left = -1, right = 0; // for binarySearching the m that works
            for (int i = 0; i < m; i++) {
                pages[i] = Integer.parseInt(line2[i]);
                right += pages[i];
                left = Math.max( left, pages[i]); // improve lower bound by a bit
            }
            //binary search a M that works
            while (left < right) {
                mid = left + ((right - left) / 2);
                if (works(mid, m, k)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // recover answers, greedy
            sb = new StringBuilder();
            output(left, m, k);
            sb.append("\n");
            out.write(sb.toString());
            out.flush();
            kases--;
        }
    }

    private static StringBuilder sb ;
    private static int[] pages;

    private static boolean works(long M, int m, int k){
        long sum = 0;
        int count = 1;
        for (int i = 0; i< m; i++){
            if (sum + pages[i] <= M){
                sum += pages[i];
            }else{
                count += 1;
                sum = pages[i];
            }
        }
        return count <= k;
    }

    private static void output(long len, int m, int k){
        Stack<Integer> st = new Stack<>();
        int remain = k-1;
        int count = 0;
        for (int i = m - 1; i>= 0; i--){
            if (count + pages[i] > len || remain > i){
                count = pages[i];
                st.push(-1); // something that will never show up
                remain -= 1;
            }else{
                count += pages[i];
            }
            st.push(pages[i]);
        }

        //recover answer
        while(st.size() > 1){
            int ans = st.pop();
            if (ans == -1){
                sb.append("/ ");
            }else{
                sb.append(String.format("%d ",ans));
            }
        }
        sb.append(String.format("%d", st.pop()));
    }
}
