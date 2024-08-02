import java.io.*;
import java.util.*;

public class Main {
    static int N, B;
    static int[][] students;
    static boolean[] visited;
    static int maxStudents = 0;

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

        // 각 학생을 쿠폰 적용 대상으로 가정하고 DFS 시작
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            int initialCost = (students[i][0] / 2) + students[i][1];
            dfs(1, initialCost, i);
        }

        System.out.println(maxStudents);
    }

    public static void dfs(int count, int currentCost, int couponIdx) {
        // 예산을 초과하면 더 이상 탐색하지 않음
        if (currentCost > B) {
            return;
        }

        // 최대 학생 수 업데이트
        maxStudents = Math.max(maxStudents, count);

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int newCost = currentCost + students[i][0] + students[i][1];
                dfs(count + 1, newCost, couponIdx);
                visited[i] = false;
            }
        }
    }
}