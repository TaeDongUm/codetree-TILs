import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] answer = new int[n][m];
        visited = new int[n][m];
        
        int currR =0;
        int currC =0;
        int dir=0;
        answer[0][0] =1;
        visited[0][0]=1;


        for(int i=2;i<=n*m;i++){
            int nextR = currR + dr[dir];
            int nextC = currC + dc[dir];
            if(isSatisfied(nextR, nextC, n, m)){
                currR = nextR;
                currC = nextC;
                answer[currR][currC] =i;
                visited[currR][currC] =1;
            }else{
                dir = (dir + 1) % 4;
                i = i-1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isSatisfied(int r, int c, int n, int m){
        if(!(r>=0 && r<n && c>=0 && c<m)) return false;
        if(visited[r][c] ==1) return false;
        return true;
    }
}