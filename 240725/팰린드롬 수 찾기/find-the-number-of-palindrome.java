import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int answer=0;

        for(int i=X;i<=Y;i++){
            int count =0;
            int compareNum = i;
            while(Math.pow(10,count) <= compareNum){
                count++;
            }
            count--;
            int palindrome = 0;

            while(compareNum>0){
                int tmp = compareNum%10;
                palindrome += Math.pow(10, count)*tmp;
                compareNum = compareNum/10;
                count--;
            }
            if(i == palindrome){
                answer++;
            }
            
        }
        System.out.println(answer);

    }
}