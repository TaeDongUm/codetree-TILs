import java.io.*;
import java.util.*;

public class Main {
    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static int[] daysMonth = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String day = br.readLine();
        int dayIdx=0;
        int diff1=0;
        int diff2=0;
        for(int i=0;i<m1;i++){
            diff1 += daysMonth[i];
        }
        for(int i=0;i<m2;i++){
            diff2 += daysMonth[i];
        }
        diff1 += d1;
        diff2 += d2;
        int diff = diff2 - diff1;
        int answer = 0;
        for(int i=0;i<diff;i++){
            dayIdx = (dayIdx +1) % 7;
            if(days[dayIdx].equals(day)){
                answer++;
            }
        }
        System.out.println(answer);


    }
}