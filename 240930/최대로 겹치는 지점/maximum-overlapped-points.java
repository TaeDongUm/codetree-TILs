import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[101];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=a;j<=b;j++){
                line[j]++;
            }
        }
        int answer= 0;
        for(int i=0;i<101;i++){
            answer = Math.max(answer, line[i]);
        }
        System.out.println(answer);
    }
}