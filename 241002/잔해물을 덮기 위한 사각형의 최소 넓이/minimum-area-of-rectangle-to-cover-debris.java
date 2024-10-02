import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[2001][2001];
        st = new StringTokenizer(br.readLine());
        int first_x1 = Integer.parseInt(st.nextToken())+1000;
        int first_y1 = Integer.parseInt(st.nextToken())+1000;
        int first_x2 = Integer.parseInt(st.nextToken())+1000;
        int first_y2 = Integer.parseInt(st.nextToken())+1000;
        for(int j=first_y1;j<first_y2;j++){
            for(int i=first_x1;i<first_x2;i++){
                map[j][i] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int sec_x1 = Integer.parseInt(st.nextToken())+1000;
        int sec_y1 = Integer.parseInt(st.nextToken())+1000;
        int sec_x2 = Integer.parseInt(st.nextToken())+1000;
        int sec_y2 = Integer.parseInt(st.nextToken())+1000;
        for(int j=sec_y1;j<sec_y2;j++){
            for(int i=sec_x1;i<sec_x2;i++){
                map[j][i] = 2;
            }
        }
        int maxX=0;
        int maxY=0;
        for(int j=first_y1;j<first_y2;j++){
            int tmpLengthX=0;
            for(int i=first_x1;i<first_x2;i++){
                if(map[j][i]==1){
                    tmpLengthX++;
                }
            }
            maxX = Math.max(maxX, tmpLengthX);
        }
        for(int i=first_x1;i<first_x2;i++){
            int tmpLengthY=0;
            for(int j=first_y1;j<first_y2;j++){
                if(map[j][i]==1){
                    tmpLengthY++;
                }
            }
            maxY = Math.max(maxY, tmpLengthY);
        }
        int answer = (maxX)*(maxY);
        System.out.println(answer);

    }
}