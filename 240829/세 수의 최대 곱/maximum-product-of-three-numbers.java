import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        int minusCount=0;
        int plusCount=0;
        int zeroCount=0;
        for(int i=0;i<n;i++){
            int tmpNum = Integer.parseInt(st.nextToken());
            if(tmpNum < 0) minusCount++;
            if(tmpNum > 0) plusCount++;
            if(tmpNum == 0) zeroCount++;
            num[i] = tmpNum;
        }
        Arrays.sort(num);
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;

        // 1. +++ 경우 이거나 --- 경우 max1
        // if(plusCount>=3 && (minusCount>=3 && plusCount==0)){
            max1 = num[n-3]*num[n-2]*num[n-1];
        // }
        // 2. --+ 경우 max2
        // if(minusCount >=2){
            max2 = num[0]*num[1]*num[n-1];
        // }

        // 3. -++ 경우 max3
        // 이 경우는 주어진 배열 크기가 반드시 3이어야 함
        // 굳이 경우를 나눌 필요 없음
        // if(minusCount ==1 && plusCount ==2){
        //     max3 = num[0]
        // }

        // 4. --- 경우 max4
        // 1번의 경우와 같다.
        // if(plusCount ==0){
        //     max4 = 
        // }

        int minusMax = 0;
        int plusMax = 0;
        if(minusCount >=2) {
            minusMax = num[0]*num[1]*num[n-1];
        }
        plusMax = num[n-3]*num[n-2]*num[n-1];
        int answer = Math.max(minusMax, plusMax);
        System.out.println(answer);
    }
}