import java.io.*;
import java.util.*;

public class Main {
    static int[] result = new int[3];
    static int answer=Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        bfs(0, input,0);
        if(answer == Integer.MIN_VALUE) System.out.println(-1);
        System.out.println(answer);


    }
    public static void bfs(int depth, int[] input, int idx){
        if(depth == 3){
            if(check(result)){
                int sum=0;
                sum = result[0] + result[1] + result[2];
                answer = Math.max(answer, sum);
                return;
            }
            return;

        }
        for(int i=idx;i<input.length;i++){
            result[depth] = input[i];
            bfs(depth+1, input, i+1);
            result[depth] = 0;
        }
    }

    public static boolean check(int[] result){
        int numExp=0;
        int num1=0;
        int num2=0;
        int num3=0;
        int[] copy = result.clone();
        while(numExp < 6){
            num1 = copy[0] % 10;
            num2 = copy[1] % 10;
            num3 = copy[2] % 10;

            if(num1 + num2 + num3 >= 10) return false;
            copy[0] =copy[0]/10;
            copy[1] =copy[1]/10;
            copy[2] =copy[2]/10;
            numExp++;
        }
        return true;
    }

}