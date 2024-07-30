import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<i+1+K && j<N;j++){
                if(arr[i] == arr[j]){
                    if(answer < arr[i]){
                        answer = arr[i];
                    }        
                } 
            }
        }
        System.out.println(answer);
    }
}