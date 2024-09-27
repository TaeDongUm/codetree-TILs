import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        while(true){
            if(a <= 11 && b<=11 && c <11){
                answer = -1;
                break;
            }
            if(a==11 && b==11 && c==11){
                break;
            }
            c--;
            answer++;
            if(c<0){
                c=59;
                b--;
            }
            if(b<0){
                b=23;
                a--;
            }

        }
        System.out.println(answer);
    }
}