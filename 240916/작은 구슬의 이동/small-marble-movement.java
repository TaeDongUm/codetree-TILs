import java.io.*;
import java.util.*;

public class Main {
    // U, D, R, L
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken())-1;
        int C = Integer.parseInt(st.nextToken())-1;
        String Dir = st.nextToken();

        for(int i=0;i<t;i++){
            int nr = R + dr[dir(Dir)];
            int nc = C + dc[dir(Dir)];
            if(nr >=0 && nr < n && nc >=0 && nc < n){
                R = nr;
                C = nc;
                continue;
            }
            Dir = flip(dir(Dir));

        }
        R = R+1;
        C = C+1;
        System.out.println(R+" "+C);


    }
    public static int dir(String Dir){
        if(Dir.equals("U")){
            return 0;
        }
        if(Dir.equals("D")){
            return 1;
        }
        if(Dir.equals("R")){
            return 2;
        }
        if(Dir.equals("L")){
            return 3;
        }
        return -1;
    }
    public static String flip(int dir){
        if(dir==0){
            return "D";
        }
        if(dir==1){
            return "U";
        }
        if(dir==2){
            return "L";
        }
        if(dir==3){
            return "R";
        }
        return "";
    }
}