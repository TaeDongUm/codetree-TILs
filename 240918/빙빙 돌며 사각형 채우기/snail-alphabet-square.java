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
        int num=0;
        int r = 0;
        int c = 0;
        int dir=0;
        int condition=0;

        while(num<n*m){
            char ch = (char)('A'+num%26);
            alpha[r][c] = ch;
            visited[r][c] =1;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isVisited(nr,nc)){
                r = nr;
                c = nc;
                num++;
            }else{
                dir = (dir +1) %4;
                nr = r + dr[dir];
                nc = c + dc[dir];
                r = nr;
                c = nc;
                num++;
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(alpha[i][j]+" ");
            }
            System.out.println();
        }
    }
//    public static boolean check(int r, int c){
//        return (r>=0 && r<n && c>=0 && c<m);
//    }
    public static boolean isVisited(int r, int c){
        if(!(r>=0 && r<n && c>=0 && c<m)) return false;
        if(visited[r][c] !=0) return false;
        return true;
    }
    // public static boolean isFull(int input){
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(visited[i][j]==1) count++;
    //         }
    //     }
    //     if(count==input)return true;
    //     return false;
    // }
}