import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int idx = n-1;
        int answer=0;
        for(int i=idx;i>=1;i--){
            if(num[i-1] > num[i]){
                answer = i-1;
            }
        }
        System.out.println(answer+1);

        
    }

}