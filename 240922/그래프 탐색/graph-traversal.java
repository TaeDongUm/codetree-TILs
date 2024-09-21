import java.io.*;
import java.util.*;

public class Main {
    static int count,N;
    static int[][] graph;
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited= new int[N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a][b] =1;
            graph[b][a] =1;

        }
        int start =0;
        count=0;
        dfs(start, 0);
        System.out.println(count);
        
    }
    public static void dfs(int start, int count1){
        visited[start]=1;
        for(int i=0;i<N;i++){
            if(graph[start][i]==1 && visited[i]==0){
                count++;
                dfs(i,count1+1);
            }
        }
    }
}