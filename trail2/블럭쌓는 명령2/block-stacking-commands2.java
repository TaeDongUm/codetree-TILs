import java.util.*;
import java.io.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] blocks = new int[N];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for(int j=A-1;j<B;j++) {
                blocks[j] +=1;
            }

        }
        // Please write your code here.
        int answer = 0;
        for(int i=0;i<N; i++) {
            if(blocks[i] > answer) {
                answer = blocks[i];
            }
        }

        System.out.println(answer);
    }
}