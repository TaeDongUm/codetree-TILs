import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        int maxLength = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] check = new int[n];

        for(int i=0;i<n-1;i++){
            if(num[i] > t && check[i] !=1){
                check[i] = 1;
                int tmpLength=1;
                int index=i;
                while(index < n-1 && num[index] > t){
                    tmpLength++;
                    index++;
                    check[index] = 1;
                }
                if(maxLength < tmpLength){
                    maxLength = tmpLength;                    
                }
            }
        }
        System.out.println(maxLength);

    }
}