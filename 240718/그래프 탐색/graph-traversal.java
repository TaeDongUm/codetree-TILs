import java.io.*;
import java.util.*;

public class Main {
    static int count=0;
    static int N=0;
    static int M=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            map[x][y] = 1;
            map[y][x] = 1;        

        }
        int[] visited = new int[N];
        visited[0] = 1; // 1번 노드 방문 처리
        dfs(map, 0, visited);
        System.out.println(count);


    }
    public static void dfs(int[][] map, int index, int[] visited){
        
        for(int j=0;j<N;j++){
            if(map[index][j] !=0 && visited[j] !=1){
                visited[j] =1;
                count++;
                dfs(map, j, visited);
            }
        }

    }
}