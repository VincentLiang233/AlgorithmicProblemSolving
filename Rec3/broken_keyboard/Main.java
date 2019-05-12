import java.util.*;

public class Main {
    private static class Node {
        public Node next;
        public String value;
        public Node(String value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] partitions = line.split("((?<=[\\[\\]])|(?=[\\[\\]]))");
            Node cur = new Node("");
            Node start = cur;
            Node end = cur;
            for(String partition : partitions) {
                if(partition.equals("[")) {
                    cur = start;
                } else if(partition.equals("]")) {
                    cur = end;
                } else {
                    Node n = new Node(partition);
                    n.next = cur.next;
                    cur.next = n;
                    if(cur == end) {
                        end = n;
                    }
                    cur = n;
                }
            }
            cur = start;
            StringBuilder builder = new StringBuilder();
            while(cur != null) {
                builder.append(cur.value);
                cur = cur.next;
            }
            System.out.println(builder.toString());
        }
    }
}