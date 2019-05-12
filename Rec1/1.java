import java.util.Scanner;


public class main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int start = in.nextInt();
            int first = in.nextInt();
            int second = in.nextInt();
            int third = in.nextInt();
            System.out.println(Degree(start,first,second, third));
        }
    }

    public static int Degree(int start, int first, int second, int third){
    	int incr = 9;
    	int a,b,c;
    	//from start to first
    	a = (40 - first + start) * incr;
    	//from first to second
    	if (second > first){
    		b = (40 - second + first) * incr;
    	}else{
    		b = (40 - first + second) * incr;
    	}
        //from second to last
    	c = (40 - third + second) * incr;
    	return a + b + c + 1080;
    }
}
