import java.io.*;
import java.util.*;
public class Main {
    // 상,오상, 오, 오하, 하, 왼하, 하, 왼상 
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static int answerR =0;
    static int answerC =0;
    static int answerColor=0;
    static int[][] Omok, visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Omok = new int[19][19];
        visited = new int[19][19];

        for(int i=0;i<19;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++){
                Omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(Omok[i][j] !=0){
                    if(sequence(i,j,Omok[i][j])){
                        System.out.println(answerColor);
                        System.out.println(answerR+" "+answerC);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
    public static boolean sequence(int r, int c, int color){
        int dir=-1;
        visited[r][c] =1;
        for(int i=0;i<8;i++){
            int count =1;
            int currR = r;
            int currC = c;
            for(int j=1;j<=4;j++){
                int nextR = currR + dr[i]*j;
                int nextC = currC + dc[i]*j;
                if(isRange(nextR, nextC) && isVisited(nextR, nextC) && Omok[nextR][nextC]==color ){
                    count++;
                }
            }
            if(count == 5){
                answerR = currR + dr[i]*2 +1;
                answerC = currC + dc[i]*2 +1;
                answerColor = color; 
                return true;
            }                              

        }
        return false;        
    }
    public static boolean isRange(int r, int c){
        if(!(r>=0 && r<19 && c>=0 && c<19)) return false;
        return true;
    }
    public static boolean isVisited(int r, int c){
        if(visited[r][c]==1) return false;
        return true;
    }
}