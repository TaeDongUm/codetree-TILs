import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        List<Integer> positionsS = new ArrayList<>();
        List<Integer> positionsN = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            
            if (c == 'S') {
                positionsS.add(x);
            } else if (c == 'N') {
                positionsN.add(x);
            }
        }
        
        int specialPositionsCount = 0;
        
        for (int x = a; x <= b; x++) {
            int closestDistanceS = Integer.MAX_VALUE;
            int closestDistanceN = Integer.MAX_VALUE;
            
            // Find the closest S
            for (int pos : positionsS) {
                int distance = Math.abs(pos - x);
                if (distance < closestDistanceS) {
                    closestDistanceS = distance;
                }
            }
            
            // Find the closest N
            for (int pos : positionsN) {
                int distance = Math.abs(pos - x);
                if (distance < closestDistanceN) {
                    closestDistanceN = distance;
                }
            }
            
            // Check if the position is special
            if (closestDistanceS <= closestDistanceN) {
                specialPositionsCount++;
            }
        }
        
        System.out.println(specialPositionsCount);
    }
}