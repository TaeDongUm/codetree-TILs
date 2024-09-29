import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        LinkedList<Integer> digit = new LinkedList<>();

        while(true){
            if(n<b){
                digit.add(n);
                break;
            }
            digit.add(n%b);
            n = n/b;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=digit.size()-1;i>=0;i--){
            sb.append(digit.get(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}