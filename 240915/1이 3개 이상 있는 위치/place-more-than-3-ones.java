import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] num = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int count=0;
                for(int k=0;k<4;k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr >=0 && nr <N && nc >=0 && nc <N){
                        if(num[nr][nc] ==1){
                            count++;
                        }
                    }

                }
                if(count >=3){
                    answer++;
                }

            }
        }
        System.out.println(answer);


    }
}