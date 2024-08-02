import java.io.*;
import java.util.*;

public class Main {
    static int N, B;
    static int[][] students;
    static boolean[] visited;
    static int answer = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        students = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken()); // 가격
            students[i][1] = Integer.parseInt(st.nextToken()); // 배송비
        }

        // DFS 시작
        dfs(0, B, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int remainingBudget, int count) {
        // 가지치기: 예산 초과 시 조기에 종료
        if (remainingBudget < 0) {
            return;
        }
        
        // 현재 최대 학생 수 업데이트
        if (count > answer) {
            answer = count;
        }
        
        // 모든 학생을 방문하는 경우 종료
        if (index >= N) {
            return;
        }
        
        // 현재 학생을 포함하지 않는 경우
        dfs(index + 1, remainingBudget, count);
        
        // 현재 학생을 포함하는 경우
        int price = students[index][0];
        int shipping = students[index][1];
        
        // 쿠폰 사용 시
        int discountedPrice = price / 2;
        dfs(index + 1, remainingBudget - discountedPrice - shipping, count + 1);
        
        // 쿠폰 미사용 시
        dfs(index + 1, remainingBudget - price - shipping, count + 1);
    }
}