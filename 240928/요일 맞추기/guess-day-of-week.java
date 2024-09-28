import java.io.*;
import java.util.*;

public class Main {
    static String[] days ={"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    static int[] monthDays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int daysIdx =1;

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int diff1=0;
        int diff2=0;
        for(int i=0;i<m1;i++){
            diff1 += monthDays[i];
        }
        for(int i=0;i<m2;i++){
            diff2 += monthDays[i];
        }
        diff1 = diff1 + d1;
        diff2 = diff2 + d2;
        int diff = diff2 - diff1;

        daysIdx=(7+diff%7 + daysIdx )%7;
        System.out.println(days[daysIdx]);
    }
}