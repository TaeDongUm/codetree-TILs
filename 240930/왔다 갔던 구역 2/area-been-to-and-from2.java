import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[2001];
        int curr = 1000;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            for(int j=1;j<=x;j++){
                if(dir.equals("R")){
                    curr++;
                    line[curr]++;
                }
                if(dir.equals("L")){
                    curr--;
                    line[curr]++;
                }
            }
        }
        int answer=0;
        for(int i=0;i<=2000;i++){
            if(line[i]>=2) answer++;
        }
        System.out.println(answer);

    }
}