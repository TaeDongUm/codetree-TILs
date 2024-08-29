import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        int[] num = new int[2*n];

        for(int i=0;i<2*n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            minValue = Math.min(num[i+n] - num[i], minValue);
        }
        System.out.println(minValue);
        
    }
}