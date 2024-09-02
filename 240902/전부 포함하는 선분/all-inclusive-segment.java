import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<int[]> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }
        int answer= 101;
        for(int i=0;i<list.size();i++){
            int minValue=101;
            int maxValue=0; 
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                minValue = Math.min(minValue, list.get(j)[0]);
                maxValue = Math.max(maxValue, list.get(j)[1]);
            }
            answer = Math.min(answer, maxValue - minValue);
        }
        System.out.println(answer);
    }
}