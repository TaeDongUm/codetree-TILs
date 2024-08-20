import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int maxStart =0;
        int minEnd = 101;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            maxStart = Math.max(maxStart, x1);
            minEnd = Math.min(minEnd, x2);
        }

        if(maxStart <= minEnd){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}