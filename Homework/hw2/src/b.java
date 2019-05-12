import java.util.Scanner;
import java.util.Stack;

public class b{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //num of cases
        int nums = in.nextInt();
        in.nextLine();
        in.nextLine();
        if (nums > 0){
            for (int i = 0; i < nums; i++) {
                String output = "";
                Stack<Character> st = new Stack<>();
                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    if (s.length() == 0)
                        break;
                    char c = s.charAt(0);
                    if (c == ' ' || c == '\n')
                        break;

                    if (Character.isDigit(c))
                        output += c;
                    else if (c == '('){
                        st.push(c);
                    }
                    else if (c == '+' || c == '-' || c == '*' || c == '/') {
                        while (!st.empty()){
                            if (st.peek() == '('){
                                break;
                            }
                            if (pre(st.peek()) >= pre(c)) {
                                output += st.pop();
                            } else {
                                break;
                            }
                        }
                        st.push(c);
                    } else if (c == ')') {
                        while (!st.empty()) {
                            if (!(st.peek() == '(')) {
                                output += st.pop();
                            } else {
                                st.pop();
                                break;
                            }
                        }
                    }
                }
                while (!st.empty()) {
                    output += st.pop();
                }
                System.out.printf("%s\n", output);
                if (i != nums-1){
                    System.out.println();
                }
            }
        }
    }

    private static int pre (char c){
        if ( c == '(' ||  c == ')'){
            return 0;
        }
        else if ( c == '+'  || c == '-'){
            return 1;
        }else if ( c =='*' || c == '/'){
            return 2;
        }
        return -1;
    }
}
