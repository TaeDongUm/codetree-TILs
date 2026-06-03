import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(st.nextToken());
        List<Integer> digits = new ArrayList<>();

        while(true) {
            if(input < 2) {
                digits.add(input);
                break;
            }

            digits.add(input % 2);
            input = input/2;
        }

        for(int i=digits.size()-1;i>=0;i--) {
            System.out.print(digits.get(i));
        }

        
    }
}