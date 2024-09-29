import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> digit = new LinkedList<>();

        while(true){
            if(n<2){
                digit.add(n);
                break;
            }    
            digit.add(n % 2);
            n = n/2;
        }
        for(int i=digit.size()-1;i>=0;i--){
            sb.append(digit.get(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}