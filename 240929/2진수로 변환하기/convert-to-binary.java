import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> digit = new LinkedList<>();

        while(n>0){
            
            digit.add(n % 2);
            n = n/2;
        }
        for(int i=digit.size()-1;i>=0;i--){
            System.out.print(digit.get(i));
        }
        
    }
}