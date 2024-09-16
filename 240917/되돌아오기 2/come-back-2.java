import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int curDir = 0;
        int startR =0;
        int startC =0;
        int answer=-1;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='F'){
                startR += dr[curDir];
                startC += dc[curDir];
            }
            if(input.charAt(i)=='L'){                
                curDir = isCurDir(curDir +1);                
            }
            if(input.charAt(i)=='R'){
                curDir = isCurDir(curDir -1);
            }
            if(check(startR, startC)){
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);
    }
    public static boolean check(int x, int y){
        if(x==0 && y==0) return true;
        return false;
    }
    public static int isCurDir(int curDir){
        if(curDir <0) return 3;
        return (curDir % 4);
    }
}