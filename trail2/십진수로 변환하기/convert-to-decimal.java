import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        int answer = 0;

        for(int i=0;i<input.length();i++) {
            int temp = Character.getNumericValue(input.charAt(i));
            answer = answer*2 + temp;
        }

        System.out.println(answer);
    }
}