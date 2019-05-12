import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class C {
    private static int maxPos( int end){
        int ans = -1;
        int output = -1;
        for (int i = 0; i <= end; i++){
            if (nums[i] > ans){
                ans = nums[i];
                output = i;
            }
        }
        return output; //position of the max element
    }

    private static int flip(int k){
        //flip at kth position
        for (int i = 0; i < k-i; i++){ // i < k/2
            swap(i,k-i);
        }
        return n - k;
    }

    private static void swap(int a, int b){
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }


    static int[] nums;
    static int n;


    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String input = in.readLine();
            if (input == null || input.equals("")) break;
            String[] line = input.split(" ");
            if (line.length == 0) break;
            StringBuilder sb = new StringBuilder();
            nums = new int[line.length];
            n = nums.length;
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < line.length ;i++){
                nums[i] = Integer.parseInt(line[i]);
            }
            for (int i = 0; i< n; i++){
                sb.append(nums[i]);
                if (i != n -1) sb.append(" ");
            }
            sb.append("\n");

            for (int p = n -1; p > 0 ; p--){
                int maxPos = maxPos(p);//max of the [0,p] portion of the array
                if (maxPos == p) continue; //this max element is at its right place
                if (maxPos != 0){//if max is at the top we can skip this
                    //flip the max to the top
                    ans.add(flip(maxPos));
                }
                //then, we flip at the unsorted part of the array
                ans.add(flip(p));
            }


            //answer gathering
            int s = ans.size();
            for (int i = 0; i< s; i++){
                sb.append(ans.get(i));
                sb.append(" ");
            }
            sb.append("0\n");


            out.write(sb.toString());
            out.flush();
        }
    }
}