import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<seats.length()-1;i++){
            if(seats.charAt(i)=='1'){
                for(int j=i+1;j<seats.length();j++){
                    if(seats.charAt(j)=='1'){
                        int tmpDistance = j-i;
                        if(minDistance> tmpDistance){
                            minDistance = tmpDistance;
                        }
                    }
                }
            }
        }

        for(int i=0;i<seats.length();i++){
            if(seats.charAt(i)=='0' && seats.charAt(i-1)=='0' && seats.charAt(i+1)=='0'){
                int leftDistance = 0;
                int rightDistance = 0;
                for(int j=i-1;j>0;j--){
                    if(seats.charAt(j)=='1'){
                        leftDistance = i-j;
                        break;
                    }
                }
                for(int k=i+1;k<seats.length();k++){
                    if(seats.charAt(k)=='1'){
                        rightDistance = k-i;
                        break;
                    }
                }
                if(leftDistance ==0 || rightDistance==0) continue;
                int tmpMin = Math.min(minDistance, Math.min(leftDistance, rightDistance));
                if(minDistance > tmpMin) minDistance = tmpMin;
            }
        }       
        System.out.println(minDistance); 

    }
}