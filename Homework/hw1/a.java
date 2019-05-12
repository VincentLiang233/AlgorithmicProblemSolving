import java.util.Scanner;

class a{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sets = in.nextInt();
        while(in.hasNextLine()){
            for (int i = 0; i < sets; i ++){
                int a = in.nextInt();
                int b = in.nextInt();
                if (a > b){
                    System.out.println(">");
                }else if (a < b){
                    System.out.println("<");
                }else{
                    System.out.println("=");
                }
            }
            break;
        }
        in.close();
    }
}
