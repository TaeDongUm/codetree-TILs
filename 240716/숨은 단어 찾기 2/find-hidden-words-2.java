import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {1,1,0,-1,-1,-1,0,1};
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
                    int nnr=0;
                    int nnc=0;

                    for(int l=0;l<8;l++){
                        nr = i + dr[l]*k;
                        nc = j + dc[l]*k;
                        if(checkRange(nr, nc) && alpha[nr][nc].equals("E")){
                            nnr = nr + dr[l]*k;
                            nnc = nc + dc[l]*k;
                            if(checkRange(nnr, nnc) && alpha[nnr][nnc].equals("E")){
                                count++;
                            }

                        }
                    }

                }
            }
        }
        System.out.println(count);


    }
    public static boolean checkRange(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }
}