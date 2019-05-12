import java.util.*;
import java.util.stream.*;

public class Main {
    public static int getUnique(String cell) {
        int digitMult = 1;
        int charMult = 1000;
        int sum = 0;
        for(int i = cell.length() - 1; i >= 0; i--) {
            char c = cell.charAt(i);
            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c) * digitMult;
                digitMult *= 10;
            } else {
                sum += ((int)c - 65 + 1) * charMult;
                charMult *= 26;
            }
        }
        return sum;
    }

    public static int findValue(Map<Integer, String> formulas, Map<Integer, Integer> values, int u) {
        if(values.containsKey(u)) {
            return values.get(u);
        } else {
            String formula = formulas.get(u);
            if(formula.charAt(0) == '=') {
                int num = Arrays.stream(formula.substring(1).split("\\+")).mapToInt(n -> findValue(formulas, values, getUnique(n))).sum();
                values.put(u, num);
                return num;
            } else {
                int num = Integer.parseInt(formula);
                values.put(u, num);
                return num;
            }
        }
    }
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nCases = in.nextInt();
        for(int c = 0; c < nCases; c++) {
            int nCols = in.nextInt();
            int nRows = in.nextInt();
            Map<Integer, String> formulas = new HashMap<Integer, String>();
            for(int row = 1; row <= nRows; row++) {
                for(int col = 1; col <= nCols; col++) {
                    int u = col * 1000 + row;
                    formulas.put(u, in.next());
                }
            }
            Map<Integer, Integer> values = new HashMap<Integer, Integer>();
            for(int row = 1; row <= nRows; row++) {
                for(int col = 1; col <= nCols; col++) {
                    int u = col * 1000 + row;
                    int val = findValue(formulas, values, u);
                    if(col == nCols) {
                        System.out.println(val);
                    } else {
                        System.out.printf("%d ", val);
                    }
                }
            }
        }
    }
}
