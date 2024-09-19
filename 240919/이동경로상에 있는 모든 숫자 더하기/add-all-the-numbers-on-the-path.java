import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[] inputNum = br.readLine().split(" ");
        int N = Integer.parseInt(inputNum[0]);
        int T = Integer.parseInt(inputNum[1]);

        String input = br.readLine();
        int[][] num = new int[N][N];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }            
        }

        int currR = N/2;
        int currC = N/2;
        int dir = 0;
        int answer = num[currR][currC];
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='L'){
                dir = (dir + 1) % 4;
            }
            if(input.charAt(i)=='R'){
                dir = (dir - 1) % 4;
                if(dir -1 <0) dir = 3;
            }
            if(input.charAt(i)=='F'){
                int nextR = currR + dr[dir];
                int nextC = currC + dc[dir];
                if(isSatisfied(nextR, nextC, N)){
                    currR = nextR;
                    currC = nextC;
                    answer += num[currR][currC];
                }
            }
        }
        System.out.println(answer);
    }
    public static boolean isSatisfied(int r, int c, int n){
        if(!(r>=0 && r<n && c>=0 && c<n)) return false;        
        return true;
    }
}