import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] birdNum = new int[11];
        Arrays.fill(birdNum, 2);
        int move =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int bird = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if(birdNum[bird] == 2){
                birdNum[bird] = position;
            }else if(birdNum[bird] != position){
                move++;
            }
        }
        System.out.println(move);
    }
}