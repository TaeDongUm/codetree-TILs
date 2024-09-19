import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int n,m;
    static int[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] alpha = new char[n][m];
        visited= new int[n][m];
        int num=1;
        int r = 0;
        int c = 0;
        int dir=0;
        int condition=0;
        alpha[r][c] = 'A';
        visited[r][c]=1;

        while(num<n*m){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isVisited(nr,nc)){
                r = nr;
                c = nc;
                char ch = (char)('A'+num%26);
                alpha[r][c] = ch;
                visited[r][c] =1;
                num++;
            }else{
                dir = (dir +1) %4;
            }

        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(alpha[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static boolean isVisited(int r, int c){
        if(!(r>=0 && r<n && c>=0 && c<m)) return false;
        if(visited[r][c] !=0) return false;
        return true;
    }

}