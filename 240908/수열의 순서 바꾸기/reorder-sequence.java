import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 연속된 오름차순 구간의 길이를 찾기
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < n; i++) {
            if (num[i] > num[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }

        // 이동 횟수는 총 배열의 길이 - 가장 긴 오름차순 구간의 길이
        int answer = n - maxLength;
        System.out.println(answer);
    }
}