import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int count=0;

        for(int i=X;i<=Y;i++){
            String num = i + "";
            int startIdx = 0;
            int endIdx = num.length()-1;
            boolean isTrue = true;
            while(startIdx < endIdx){
                if(num.charAt(startIdx) != num.charAt(endIdx)){
                    isTrue = false;
                    break;
                }
                startIdx++;
                endIdx--;
            }
            if(isTrue){
                count++;
            }
            
        }
        System.out.println(count);

    }
}