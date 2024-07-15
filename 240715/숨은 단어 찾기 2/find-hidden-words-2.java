import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {1,1,0,-1,-1,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] alpha = new String[N][M];
        for(int i=0;i<N;i++){
            alpha[i] = br.readLine().split("");
        }
        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(alpha[i][j].equals("L")){
                    int nr=0;
                    int nc=0;
                    int k =1;

                    for(int l=0;l<8;l++){
                        nr = i + dr[l]*k;
                        nc = j + dc[l]*k;
                        if(nr >=0 && nr <N && nc>=0 && nc<M){
                            if(alpha[nr][nc].equals("E")){
                                int nnr = nr + dr[l]*k;
                                int nnc = nc + dc[l]*k;
                                if(nnr >=0 && nnr <N && nnc >=0 && nnc<M){
                                    if(alpha[nnr][nnc].equals("E")){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        System.out.println(count);


    }
}