import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        // 부분합 계산 (슬라이딩 윈도우)
        int[] sum = new int[n - m + 1];
        int currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += num[i];
        }
        sum[0] = currentSum;
        for (int i = 1; i <= n - m; i++) {
            currentSum = currentSum - num[i - 1] + num[i + m - 1];
            sum[i] = currentSum;
        }

        // DP 테이블
        int[][] dp = new int[4][n - m + 1];

        // DP 초기값 세팅
        for (int i = 1; i <= 3; i++) {
            for (int j = (i - 1) * m; j <= n - m; j++) {
                if (i == 1) {
                    // 첫 번째 상자일 때는 j > 0인 경우만 dp[i][j-1]과 비교
                    if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], sum[j]);
                    } else {
                        dp[i][j] = sum[j]; // j == 0일 때는 sum[0]을 그대로 사용
                    }
                } else if (j >= m) {
                    // 두 번째 상자부터는 겹치지 않는 이전 상자의 최대 합과 비교
                    if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + sum[j]);
                    } else {
                        dp[i][j] = dp[i - 1][j - m] + sum[j];
                    }
                }
            }
        }

        // 최종 출력
        System.out.println(dp[3][n - m]);
    }
}