import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] map = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                sum += Math.abs(j-i)*map[j];
            }
            if(result > sum){
                result = sum;
            }
        }
        System.out.println(result);
    }
}