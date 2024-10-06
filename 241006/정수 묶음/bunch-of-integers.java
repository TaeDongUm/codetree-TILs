import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int m;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        int[] visited = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        group(0, 0, visited);
        System.out.println(answer);

    }
    public static void group(int Idx, int count, int[] visited){
        if(count ==3){
            int numSum=0;
            for(int i=0;i<visited.length;i++){
                if(visited[i]==1){
                    numSum += num[i];
                }
            }
            answer = Math.max(answer, numSum);            
        }
        for(int i=Idx;i<visited.length-m+1;i++){
            for(int j=i;j<i+m;j++){
                if(visited[j]==1) continue;
                visited[j] =1;
            }
            group(Idx+m,count+1,visited);
            for(int j=i;j<i+m;j++){
                visited[j] =0;
            }
            
        }
    }
}