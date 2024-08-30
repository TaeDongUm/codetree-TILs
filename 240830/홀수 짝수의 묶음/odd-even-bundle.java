import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int evenCount=0;
        int oddCount=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int tmpNum = Integer.parseInt(st.nextToken());
            if(tmpNum %2==0) evenCount++;
            if(tmpNum %2!=0) oddCount++;
        }
        int answer =0;

        if(evenCount > oddCount){
            answer = oddCount*2 + 1;
        }else{
            while(evenCount <= oddCount){
                if(evenCount ==0){
                    evenCount++;
                    oddCount-=2;
                    continue;
                } 
                if((oddCount - evenCount)% 2==0){
                    answer = evenCount*2 +1;
                }
                evenCount++;
                oddCount -=2;
            }
        }
        System.out.println(answer);
    }
}