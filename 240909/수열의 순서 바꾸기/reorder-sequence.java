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
        int idx = n-2;
        int answer=-1;
        for(int i=idx;i>=0;i--){
            if(num[i] > num[i+1]){
                answer = i;
            }
        }
        System.out.println(answer+1);

        
    }

}