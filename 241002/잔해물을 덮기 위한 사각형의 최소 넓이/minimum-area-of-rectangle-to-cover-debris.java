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
        int maxX = first_x2 - first_x1;
        int maxY = first_y2 - first_y1;

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
        int answerX=0;
        for(int j=first_y1;j<first_y2;j++){
            boolean xSequence=true;
            int tmpLengthX=0;
            int sign=0;
            int signCount=0;
            for(int i=first_x1;i<first_x2;i++){
                if(map[j][i]==1){
                    tmpLengthX++;
                    if(sign ==-1){
                        signCount++;
                    }
                    sign=1;
                } 
                    
                if(map[j][i]==2){
                    if(sign==1){
                        signCount++;
                    }
                    sign=-1;
                }
            }
            if(signCount>=2) answerX = maxX;
            else answerX = Math.max(answerX, tmpLengthX);
        }

        
        int answerY=0;
        for(int i=first_x1;i<first_x2;i++){
            int tmpLengthY=0;
            int sign=0; // -1: -값, 0: 부호 없음, 1: +값 
            int signCount=0;
            for(int j=first_y1;j<first_y2;j++){
                if(map[j][i]==1){
                    tmpLengthY++;
                    if(sign == -1){
                        signCount++;
                    }
                    sign=1;
                }
                if(map[j][i]==2){
                    if(sign == 1){
                        signCount++;
                    }
                    sign=-1;
                }
            }
            if(signCount >=2) answerY = maxY;
            else answerY = Math.max(answerY, tmpLengthY);
        }
        int answer = (answerX)*(answerY);
        System.out.println(answer);

    }
}