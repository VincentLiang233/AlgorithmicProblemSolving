import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class e {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        PriorityQueue<String> table = new PriorityQueue<>(5001, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        while (line != null){
            line = line.trim();
            line = line.replaceAll("[^a-zA-Z]+"," ");//strip all special characters
            String[] words = line.split("\\s+");//all sorts of whitespaces
            for (String word: words){
                word = word.toLowerCase();
                if ((!word.equals("")) && (!word.equals(" ")) && (!table.contains(word))){
                    table.add(word);
                }
            }
            //supposedly that will work
            line = in.readLine();
        }
        //no more line
        //output
        StringBuilder s = new StringBuilder();
        int size = table.size();
        for (int i = 0; i < size; i++){
            s.append(table.poll());
            s.append("\n");
        }
        out.write(s.toString());
        out.flush();
    }
}
