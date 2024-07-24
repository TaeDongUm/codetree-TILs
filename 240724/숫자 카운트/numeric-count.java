import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer=0;
        LinkedList<int[]> list = new LinkedList<>();

        for(int i=0;i<N;i++){            
            int[] input = new int[3];
            st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());
            list.add(input);
        }             

        for(int i=123;i<=987;i++){
            int h = i/100;
            int t = (i/10)%10;
            int o = i%10;
            
            if(h == t || t==o || o==h) continue;
            if(h == 0 || t==0 || o==0) continue;
            boolean flag = true;
            for(int j=0;j<list.size();j++){
                int oneCount =0;
                int twoCount =0;
                int guess = list.get(j)[0];
                int inputOneCount = list.get(j)[1];
                int inputTwoCount = list.get(j)[2];
                
                int nh = guess/100;
                int nt = (guess/10)%10;
                int no = guess%10;

                if(h == nh) oneCount++;
                if(t == nt) oneCount++;
                if(o == no) oneCount++;

                // if(h == nt || h == no) twoCount++;
                // if(t == nh || t == no) twoCount++;
                // if(o == nh || o == nt) twoCount++;

                if(nh == t || nh == o) twoCount++;
                if(nt == h || nt == o) twoCount++;
                if(no == h || no == t) twoCount++;

                if(oneCount != inputOneCount || twoCount != inputTwoCount) flag = false;


            }
            if(flag){
                answer++;
            }
        }
        System.out.println(answer);
    }
}