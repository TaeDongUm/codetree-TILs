import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            lines[i][0] = x1;
            lines[i][1] = x2;
        }
        boolean isOverlapped = false;
        for(int i=0;i<lines.length;i++){
            int maxStart = 0;
            int minEnd = 101;
            for(int j=0;j<lines.length;j++){
                if(i== j) continue;
                maxStart = Math.max(maxStart, lines[i][0]);
                minEnd = Math.min(minEnd, lines[i][1]);
            }
            if(maxStart <= minEnd) isOverlapped = true;
        }
        if(isOverlapped){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}