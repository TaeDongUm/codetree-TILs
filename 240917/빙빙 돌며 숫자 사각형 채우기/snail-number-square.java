import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] visited; // 0 값이 방문 안한 곳
    static int[][] answer;   
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0}; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int num=1;        

        visited = new int[n][m];
        answer = new int[n][m];

        int r = 0;
        int c = 0;
        String curDir = "R";
        answer[0][0] =1;
        visited[r][c] = 1;
        num++;
        while(num <=n*m){        
            if(curDir.equals("R")){
                int nr = r;
                int nc = c + dc[0];
                if(isCondition(nr, nc)){
                    answer[nr][nc] = num;
                    visited[nr][nc] = 1;
                    r = nr;
                    c = nc;
                    num++;
                }else{
                    curDir = "D";
                    continue;
                }
            }
            if(curDir.equals("D")){
                int nr = r + dr[1];
                int nc = c;
                if(isCondition(nr, nc)){
                    answer[nr][nc] = num;
                    visited[nr][nc] = 1;
                    r = nr;
                    c = nc;
                    num++;
                }else{
                    curDir = "L";
                    continue;
                }
            }
            if(curDir.equals("L")){
                int nr = r;
                int nc = c + dc[2];
                if(isCondition(nr, nc)){
                    answer[nr][nc] = num;
                    visited[nr][nc] = 1;
                    r = nr;
                    c = nc;
                    num++;
                }else{
                    curDir = "U";
                    continue;
                }

            }
            if(curDir.equals("U")){
                int nr = r + dr[3];
                int nc = c ;
                if(isCondition(nr, nc)){
                    answer[nr][nc] = num;
                    visited[nr][nc] = 1;
                    r = nr;
                    c = nc;
                    num++;
                }else{
                    curDir = "R";
                    continue;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }



    }
    public static boolean isCondition(int r, int c){
        if(!(r>=0 && r< n && c>=0 && c<m)) return false;
        if(visited[r][c]==1) return false;
        return true;
    }

}