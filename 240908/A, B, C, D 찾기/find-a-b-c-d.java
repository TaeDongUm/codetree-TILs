import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int[] num = new int[15];
        for(int i=0;i<15;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int a = num[0];
        int b = num[1];
        int c = num[2];
        int d = num[14] - num[0] - num[1] - num[2];

        System.out.println(a+" "+b+" "+c+" "+d);
    }
}