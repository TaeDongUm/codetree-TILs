import java.io.*;
import java.util.*;

public class Main {
    static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for(int i=X;i<=Y;i++){
            checkNum(i);
        }
        System.out.println(answer);
    }

    public static void checkNum(int X){
        int[] num = new int[10];
        while(X>0){
            int tmpNum = X%10;
            num[tmpNum] += 1;
            X = X/10;
        }
        int countOne = 0;
        int countZero = 0;
        for(int i=0;i<num.length;i++){
            if(num[i] == 1) countOne++;
            if(num[i] == 0) countZero++;
        }
        if(countOne ==1 && countZero ==8) answer++;

    }
}