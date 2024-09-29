import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num=1;
        int answer=0;
        for(int i=input.length()-1;i>=0;i--){
            answer += num*(int)(input.charAt(i)-'0');
            num *=2;
        }
        System.out.println(answer);
    }
}