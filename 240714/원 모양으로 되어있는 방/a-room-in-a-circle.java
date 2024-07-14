import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] room = new int[N];
        for(int i=0;i<N;i++){
            room[i] = Integer.parseInt(br.readLine());

        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int count=1;
            int current=i;
            int sum=0;
   
            while(count <=N-1){
                current++;
                if(current >=N) current = current % N;
                sum += count*room[current];
                count++;
      
            }
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }
}