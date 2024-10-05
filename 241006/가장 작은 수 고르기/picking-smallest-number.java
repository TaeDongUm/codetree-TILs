import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            int tmpNum = Integer.parseInt(st.nextToken());
            answer = Math.min(answer, tmpNum);
        }
        System.out.println(answer);
    }
}