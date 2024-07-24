import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> listS = new LinkedList<>();
        LinkedList<Integer> listN = new LinkedList<>();

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            char tmpChar = st.nextToken().charAt(0);
            int tmpIdx = Integer.parseInt(st.nextToken());
            if(tmpChar == 'S'){
                listS.add(tmpIdx);
            }else{
                listN.add(tmpIdx);
            }
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
            for(int j=0;j<listS.size();j++){
                int tmp = Math.abs(i - listS.get(j));
                if(d1 > tmp) d1 = tmp;
            }
            for(int j=0;j<listN.size();j++){
                int tmp = Math.abs(i - listN.get(j));
                if(d2 > tmp) d2 = tmp;
            }

            if(d1 <= d2) answer++;
        }

        System.out.println(answer);
        
        


      
    }
}