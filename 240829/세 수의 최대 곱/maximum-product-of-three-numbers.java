import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int tmpNum = Integer.parseInt(st.nextToken());
            num[i] = tmpNum;
        }
        Arrays.sort(num);
        int max1 = 0;
        int max2 = 0;

        max1 = num[n-3]*num[n-2]*num[n-1];
        max2 = num[0]*num[1]*num[n-1];

        int answer = Math.max(max1, max2);
        System.out.println(answer);
    }
}