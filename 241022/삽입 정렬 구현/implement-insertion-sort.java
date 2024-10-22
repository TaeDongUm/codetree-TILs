import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0;i<n;i++){   
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<num.length;i++){
            int key = num[i];
            int j = i-1;
            while(j>=0 && num[j]>key){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = key;
        }
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }

    }
}