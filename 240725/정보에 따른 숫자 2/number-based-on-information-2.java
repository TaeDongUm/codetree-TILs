import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        LinkedList<String[]> list = new LinkedList<>();

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            String[] input = new String[2];
            input[0] = st.nextToken();
            input[1] = st.nextToken();
            list.add(input);
        }

        // Collections.sort(list, new Comparator<String[]>(){
        //     @Override
        //     public int compare(String[] s1, String[] s2){
        //         return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
        //     }

        // });

        int answer=0;

        for(int i=a;i<=b;i++){
            int sx = i;
            int nx = i;
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;
            for(int j=0;j<list.size();j++){
                if(list.get(j)[0].equals("S")){
                    int tmp = Math.abs(i - Integer.parseInt(list.get(j)[1]));
                    if(d1 > tmp) d1 = tmp;
                }
                if(list.get(j)[0].equals("N")){
                    int tmp = Math.abs(i - Integer.parseInt(list.get(j)[1]));
                    if(d2 > tmp) d2 = tmp;
                }
            }
            if(d1 <= d2) answer++;
        }

        System.out.println(answer);
        
        


      
    }
}