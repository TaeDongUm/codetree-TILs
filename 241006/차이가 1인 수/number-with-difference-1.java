import java.util.*;

public class Main {
    static final int MOD = 1000000007; // 10^9 + 7로 나눈 나머지를 구하기 위한 값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n자리 수

        // DP 테이블 dp[i][j]: i자리 수에서 마지막 숫자가 j인 경우의 가짓수
        long[][] dp = new long[n + 1][10];

        // 1자리 수일 때는 각 숫자가 1개의 경우를 가짐
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 2자리 수 이상일 때는 이전 자리의 숫자에 따라 차이가 1 나는 숫자를 선택
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1]; // j-1에서 오는 경우
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1]; // j+1에서 오는 경우
                }
                dp[i][j] %= MOD; // 나머지 연산
            }
        }

        // n자리 수에서 가능한 모든 가짓수를 계산
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        // 결과 출력
        System.out.println(result);
    }
}