import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i=0;i<6;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int max = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int[] cal = new int[3];
        for(int i=0;i<3;i++){
            cal[i] = arr[i] + arr[5-i];
        }
        Arrays.sort(cal);
        max = cal[2] - cal[0];
        System.out.println(max);
    }
}