import java.util.Scanner;
import java.util.Arrays;
public class a{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()){
			int flag = 0;
			int cases = in.nextInt();
			if (cases == 0){
				break;
			}
			int[] nums = new int[cases];
			for (int i = 0; i < cases; i ++){
				nums[i] = in.nextInt();
			}
			Arrays.sort(nums);
			int previous = 0;
			for (int j = 0; j < cases; j ++){
				if (nums[j] - previous > 200){
					flag = 1;
					break;
				}
				previous = nums[j];
			}

			if (nums[0] > 100){
				flag = 1;
			}

			if (flag != 1){
				System.out.println("POSSIBLE");
			}else{
				System.out.println("IMPOSSIBLE");
			}
		}
		in.close();
	}
}
