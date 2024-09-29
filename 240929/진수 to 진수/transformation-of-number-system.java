import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String n = br.readLine();
        int num = 0;
        for(int i=0;i<n.length();i++){
            num = num*8 + n.charAt(i)-'0';
        }
        LinkedList<Integer> digit = new LinkedList<>();

        while(true){
            if(num<b){
                digit.add(num);
                break;
            }
            digit.add(num%b);
            num = num/b;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=digit.size()-1;i>=0;i--){
            sb.append(digit.get(i));
        }
        System.out.println(sb.toString());
    }
}