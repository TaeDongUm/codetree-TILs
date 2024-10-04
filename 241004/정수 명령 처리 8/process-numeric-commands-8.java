import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value=0;
            if(st.hasMoreTokens()){
                value = Integer.parseInt(st.nextToken());
            }
            if(command.equals("push_back")){
                list.addLast(value);
            }
            if(command.equals("push_front")){
                list.addFirst(value);
            }
            if(command.equals("pop_front")){
                System.out.println(list.pollFirst());
            }
            if(command.equals("pop_back")){
                System.out.println(list.pollLast());
            }
            if(command.equals("back")){
                System.out.println(list.peekLast());
            }
            if(command.equals("size")){
                System.out.println(list.size());
            }
            if(command.equals("empty")){
                if(list.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            if(command.equals("front")){
                System.out.println(list.peekFirst());
            }
        }
    }
}