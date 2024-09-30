import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[201];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())+100;
            int b = Integer.parseInt(st.nextToken())+100;
            for(int j=a;j<=b-1;j++){
                line[j] += 1;
            }
        }
        int answer=0;
        for(int i=0;i<line.length;i++){
            answer = Math.max(line[i], answer);
        }
        System.out.println(answer);
    }
}