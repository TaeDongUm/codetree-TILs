import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count=n;
        boolean isSorted = true;
        while(isSorted){
            isSorted = false;            
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    isSorted= true;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}