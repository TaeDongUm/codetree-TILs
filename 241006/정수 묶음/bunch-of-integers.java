import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        int numSum=0;
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());            
            numSum += num[i];
        }
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        for(int i=0;i<n-m*3;i++){
            numSum -= num[i];
        }
        System.out.println(numSum);

    }
}