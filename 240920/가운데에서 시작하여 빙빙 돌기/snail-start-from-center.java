import java.io.*;
import java.util.*;

public class Main {
    static int[] dr= {0,-1,0,1};
    static int[] dc= {1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] answer = new int[n][n];


        int currR = n/2;
        int currC = n/2;
        int dir=0;
        answer[currR][currC]=1;
        int moveNum=1;
        int move=moveNum;
        int dirCount=1;        

        for(int i=2;i<=n*n;i++){
            // 1. move만큼 한 방향으로 이동
            // 2. move 다 소진시 방향 바꾸기
            // 3. 방향을 2번 바꾸면 moveNum++ 하고 move에 넣기
            if(dirCount==2){
                dirCount=0;
                moveNum++;
            }
            if(move==0){
                dir = (dir + 1) % 4;
                dirCount++;
                move = moveNum;
                currR = currR + dr[dir];
                currC = currC + dc[dir];
                answer[currR][currC] =i;
                move--;
            }else if(move !=0){
                move--;
                currR = currR + dr[dir];
                currC = currC + dc[dir];
                answer[currR][currC] = i;                
            }          

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}