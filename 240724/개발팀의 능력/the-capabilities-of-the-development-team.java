import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static boolean isTrue = true;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] ability = new int[5];
        for(int i=0;i<5;i++){
            ability[i] = Integer.parseInt(st.nextToken());
        }
        int[] newTeam= new int[5];
        int[] visited = new int[5];
        cal(ability, visited, 0, newTeam);
        if(isTrue){
            System.out.println(min);

        }else{
            System.out.println(-1);
        }


    }
    public static void cal(int[] ability, int[] visited, int count, int[] newTeam ){
        if(count == 5){
             int team1 = newTeam[0] + newTeam[1];
             int team2 = newTeam[2] + newTeam[3];
             int team3 = newTeam[4];
             if(team1 == team2 || team2 == team3 || team3 == team1) return;
             int[] Score = new int[3];
             Score[0] = team1;
             Score[1] = team2;
             Score[2] = team3;
             Arrays.sort(Score);
             if(min > Score[2] - Score[0]){
                min = Score[2] - Score[0];
                isTrue = true;
             } 
             
             return;
             
        }

        for(int i=0;i<ability.length;i++){
            if(visited[i] !=1){
                visited[i] = 1;
                if(count >=5) count = count%5;
                newTeam[count] = ability[i];
                cal(ability, visited, count+1, newTeam);
                visited[i] =0;

            }
        }
    }
}