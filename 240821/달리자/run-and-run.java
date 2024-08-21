import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] before = new int[N];
        int[] after = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<N;j++){
            before[j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j=0;j<N;j++){
            after[j] = Integer.parseInt(st.nextToken());
        }
        int move =0;
        for(int i=N-2;i>=0;i--){
            for(int j=N-1;j>=i+1;j--){
                if(after[j]-before[j] == 0) continue;
                if(before[i] <= after[j]-before[j]){
                    move += (j-i)*before[i];
                    before[j] = before[j] + before[i];
                    before[i] = 0;
                }else{
                    move += (after[j] - before[j])*(j-i);
                    before[i] = before[i] - (after[j] - before[j]);
                    before[j] = before[j] + (after[j] - before[j]);
                } 
            }
        }
        System.out.println(move);
    }
}