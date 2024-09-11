import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxClock = 1_000_000;
        int[] moveA = new int[maxClock];
        int[] moveB = new int[maxClock];
        moveA[0] = 0;
        moveB[0] = 0;

        int aIndex=1;
        int bIndex=1;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j=0;j<t;j++){
                moveA[aIndex] = v;
                aIndex++;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j=0;j<t;j++){
                moveB[bIndex] = v;
                bIndex++;
            }
        }
        int preCompare = 0; // 1: A가 크다 , 0: 같다, -1: B가 크다
        int everyTimeValue = 0;
        int answer=0;

        for(int i=0;i<aIndex;i++){
            int tmpNum = moveA[i] - moveB[i];

            if(tmpNum > 0){
                everyTimeValue = 1;
            }
            
            if(tmpNum == 0){
                everyTimeValue = 0;
            }
            
            if(tmpNum < 0){
                everyTimeValue = -1;
            }
            if(everyTimeValue != preCompare){
                answer++;
                preCompare = everyTimeValue;
            }         

        }    
        System.out.println(answer);

    }            
}