import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int inputMinDis = Integer.MAX_VALUE;
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i)=='1'){
                for(int j=i+1;j<input.length();j++){
                    if(input.charAt(j)=='1'){
                        if(inputMinDis > j-i) {
                            inputMinDis = j-i;
                        }
                    }
                }
            }
        }
        int answer =-1;

        for(int i=0;i<input.length();i++){
            int leftDistance= 1000;
            int rightDistance= 1000;
            int tmpDistance=0;
            if(input.charAt(i)=='0'){
                // leftDistance
                for(int j=i;j>=0;j--){
                    if(input.charAt(j)=='1'){
                        leftDistance = i-j;
                        break;
                    }
                }

                // rightDistance
                for(int j=i;j<input.length();j++){
                    if(input.charAt(j)=='1'){
                        rightDistance = j-i;
                        break;
                    }
                }
                tmpDistance = Math.min(inputMinDis, Math.min(leftDistance, rightDistance));

            }
            answer = Math.max(answer, tmpDistance);
        }
        System.out.println(answer);
    }
}