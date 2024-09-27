import java.io.*;
import java.util.*;

public class Main {
    static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int answer=1;
        while(true){
            if(m1==m2 && d1==d2){
                break;
            }
            answer++;
            d1++;
            if(d1>days[m1]){
                m1++;
                d1=1;
            }
        }
        System.out.println(answer);


    }
}