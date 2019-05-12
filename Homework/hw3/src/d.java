import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;


public class d {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String ts = in.readLine();
        int kcases = 1;
        while (!(Integer.parseInt(ts) == 0)){
            HashMap<Integer, Integer> identification = new HashMap<>(); //personID, teamID
            int teams = Integer.parseInt(ts);
            for (int i = 0 ; i < teams; i ++){
                String[] line = in.readLine().split(" ");
                for (int j = 0; j < Integer.parseInt(line[0]); j ++){
                    identification.put(Integer.parseInt(line[j+1]),i);
                }
            }
            //after constructing the table of identification
            //use a LinkedList to simulate the process
            LinkedList<ArrayDeque<Integer>> wholeList = new LinkedList<>();
            //each team is an arrayDeque
            //at most 1000 teams
            int[] teamIn = new int[1001];//all 0 at first
            HashMap<Integer,ArrayDeque<Integer>> checkTeam = new HashMap<>(); //teamID, teamQueue
            String[] nextLine = in.readLine().split(" ");
            System.out.println("Scenario #" + kcases);
            while (!nextLine[0].equals("STOP")){
                if (nextLine[0].equals("ENQUEUE")){
                    int personNum = Integer.parseInt(nextLine[1]);
                    int teamNum = identification.get(personNum);
                    if (teamIn[teamNum] == 0){
                        //no one is in the team yet
                        //create the queue for this team and push it in the wholeList
                        ArrayDeque<Integer> team = new ArrayDeque<>();
                        team.addLast(personNum);
                        checkTeam.put(teamNum,team);
                        wholeList.addLast(team);
                        teamIn[teamNum] = 1;
                    }else{
                        //if there is someone in the wholeList
                        ArrayDeque<Integer> myTeam = checkTeam.get(teamNum);
                        myTeam.addLast(personNum);
                    }
                }else{
                    //DEQUEUE
                    ArrayDeque<Integer> theTeam = wholeList.getFirst();
                    //assuming we wont dequeue someone not in the list
                    int theGuy = theTeam.pollFirst();
                    int teamNum = identification.get(theGuy);
                    if (theTeam.isEmpty()){
                        //if after polling the first guy out the team is empty
                        teamIn[teamNum] = 0;
                        wholeList.remove(theTeam);
                    }
                    System.out.println(theGuy);
                }
                nextLine = in.readLine().split(" ");
            }
            System.out.println();
            kcases ++;
            ts = in.readLine();
        }

    }
}