import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int answer=0;
        while(true){
            if(num[0]==1){
                if(isAlign(0,n-1)){
                    break;
                }
                for(int i=0;i<n;i++){
                    if(num[i]==n){
                        reposition(0,i);
                        answer++;
                    }
                }
            }
            if(num[0]==n){
                reposition(0, n-1);
                answer++;
            }
            if(num[0] !=1 || num[0] != n){
                for(int i=1;i<n;i++){
                    if(num[0]-1 == num[i]){
                        reposition(0, i);
                        break;
                    }
                }
                answer++;
            }        
        }
        System.out.println(answer);
    }
    public static void reposition(int pre, int move){
        int tmpNum = num[pre];
        for(int i=pre+1;i<=move;i++){
            num[i-1] = num[i];
        }
        num[move] = tmpNum;
        return;
    }
    public static boolean isAlign(int start, int end){

        for(int i=start;i<end;i++){
            if(num[i+1] -num[i] !=1){
                return false;
            }
        }        
        return true;
    }
}