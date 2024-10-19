import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<numArr.length;i++){
            int min=i;
            for(int j=i;j<numArr.length;j++){
                if(numArr[min] > numArr[j]){
                    min = j;
                }
            }

            int tmp = numArr[i];
            numArr[i] = numArr[min];
            numArr[min] = tmp;
        }
        for(int k=0;k<numArr.length;k++){
            System.out.print(numArr[k]+" ");
        }
    }
}