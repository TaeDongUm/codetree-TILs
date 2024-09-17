import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            map[r][c] = 1;
            int count=0;
            for(int j=0;j<4;j++){
                int nr = r + dr[j];
                int nc = c + dc[j];
                if(nr>=0 && nr<N && nc>=0 && nc <N){
                    if(map[nr][nc]==1){
                        count++;
                    }
                }
            }
            if(count ==3){
                sb.append(1);                
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}