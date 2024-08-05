import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int key =0;
            int value=0;
            if(input.equals("add")){
                key = Integer.parseInt(st.nextToken());
                value = Integer.parseInt(st.nextToken());
            }else{
                key =Integer.parseInt(st.nextToken());
            }

            if(input.equals("add")){
                map.put(key, value);
            }else if(input.equals("remove")){
                map.remove(key);
            }else if(input.equals("find")){
                if(map.containsKey(key)){
                    System.out.println(map.get(key));
                }else{
                    System.out.println("None");
                }
            }
        }
    }
}