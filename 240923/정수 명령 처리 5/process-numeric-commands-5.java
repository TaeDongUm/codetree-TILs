import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer> dynamic = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int comNum=0;
            if(command.equals("push_back") || command.equals("get")){
                comNum = Integer.parseInt(st.nextToken());
            }
            if(command.equals("push_back")){
                push_back(comNum);
            }
            if(command.equals("pop_back")){
                pop_back();
            }
            if(command.equals("size")){
                dynamic_size();
            }
            if(command.equals("get")){
                dynamic_get(comNum);
            }

        }
    }
    public static void push_back(int A){
        dynamic.add(A);
    }
    public static void pop_back(){
        dynamic.remove(dynamic.size()-1);
    }
    public static void dynamic_size(){        
        System.out.println(dynamic.size());
    }
    public static void dynamic_get(int K){
        System.out.println(dynamic.get(K-1));
    }
}