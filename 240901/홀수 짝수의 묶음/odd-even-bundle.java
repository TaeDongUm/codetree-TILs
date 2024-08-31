import java.io.*;
import java.util.*;

public class Main {
    static int answer=Integer.MIN_VALUE;
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

        if(evenCount > oddCount){
            answer = oddCount*2 + 1;
        }else{
            pack(evenCount, oddCount);

            // while(evenCount <= oddCount){
            //     if(evenCount ==0 || oddCount - evenCount ==1){
            //         evenCount++;
            //         oddCount-=2;
            //         continue;
            //     } 

            //     answer = evenCount*2;
            //     if((oddCount - evenCount) ==2){
            //         answer = evenCount*2 +1;
            //     }
            //     evenCount++;
            //     oddCount -=2;
            // }
        }
        System.out.println(answer);
    }
    public static void pack(int evenCount, int oddCount){
        int tmpEvenCount = 0;
        int tmpOddCount = 0;
        int checkEvenCount=0;
        int cal=0;
        while(tmpEvenCount <= oddCount/2){
            tmpEvenCount++;
            for(int i=tmpEvenCount*2;i<oddCount;i+=2){
                tmpOddCount = oddCount - i;
                checkEvenCount = tmpEvenCount + evenCount;
                if(check(checkEvenCount, tmpOddCount)){
                    if(checkEvenCount==tmpOddCount){
                        cal = checkEvenCount*2;
                        if(answer < cal) answer = cal;
                    }else if(checkEvenCount - tmpOddCount ==1){
                        cal = tmpOddCount*2 +1;
                        if(answer < cal) answer = cal;
                    }
                }
            }
        }
    }
    public static boolean check(int evenCount, int oddCount){
        if((evenCount - oddCount ==0 ) || (evenCount - oddCount ==1)){
            return true;
        } 
        return false;
    }
}