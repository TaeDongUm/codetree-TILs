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

        int diff = m2*monthDays[m2]+d2-m1*monthDays[m1]-d1;
        boolean isMinus = false;
        // while(true){
        //     if(m1==m2 && d1==d2){
        //         break;
        //     }
        //     d1++;
        //     daysIdx++;
        //     if(d1>monthDays[m1]){
        //         d1=1;
        //         m1++;
        //     }
        //     if(daysIdx>6){
        //         daysIdx = daysIdx % 7;
        //     }
        // }

        if(diff<0){
            isMinus = true;
            diff = 7- (diff*(-1) % 7);
            daysIdx = (daysIdx + diff)% 7;
            System.out.println(days[daysIdx]);
        }else{
            daysIdx = (daysIdx + diff)% 7;
            System.out.println(days[daysIdx]);
        }

    }
}