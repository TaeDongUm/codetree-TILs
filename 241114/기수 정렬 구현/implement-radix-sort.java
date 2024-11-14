import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());        
        String[] num = new String[n];
        
        st = new StringTokenizer(br.readLine());
        int count=num.length-1;

        int cnt=0;
        for(int i=0;i<n;i++){
            num[i] = st.nextToken();
            cnt = Math.max(cnt, num[i].length());

        }
        for(int size=0;size<cnt;size++){
            while(count >0){
                for(int i=0;i<num.length-1;i++){
                    int compare = comp.compare(num[i],num[i+1]);
                    if(compare >0){
                        String tmp = num[i];
                        num[i] = num[i+1];
                        num[i+1] = tmp;
                    }

                }

                count--;
            }
        }

        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");

        }        

    }
    public static Comparator<String> comp = new Comparator<String>(){

        @Override
        public int compare(String a, String b){            
            int tmpA = Integer.parseInt(a);
            int tmpB = Integer.parseInt(b);
            return tmpA-tmpB;
        }
    };
}