import java.util.Scanner;
import java.math.*;

class rec{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			int n = in.nextInt();
			//n stands for the number of cases
			for (int i = 0; i < n; i ++){
				int stores = in.nextInt();
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				//looping through each store for each case
				for (int j = 0; j < stores; j++){
					int val = in.nextInt();
					min = Math.min(val,min);
					max = Math.max(val,max);
				}
				System.out.println((max - min)*2);
			}
		}
	}
}
