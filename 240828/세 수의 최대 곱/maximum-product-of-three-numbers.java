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
        for(int i=0;i<n;i++){
            int tmpNum = Integer.parseInt(st.nextToken());
            if(tmpNum < 0) minusCount++;
            num[i] = tmpNum;
        }
        Arrays.sort(num);
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