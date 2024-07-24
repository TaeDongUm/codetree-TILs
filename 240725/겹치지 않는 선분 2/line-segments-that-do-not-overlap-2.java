import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] segments = new int[N][2];

        // 선분 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            segments[i][0] = x1;
            segments[i][1] = x2;
        }

        int count = 0;

        // 선분 간의 교차 여부를 판단
        for (int i = 0; i < N; i++) {
            boolean isSpecial = true;
            int x1 = segments[i][0];
            int x2 = segments[i][1];

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                int y1 = segments[j][0];
                int y2 = segments[j][1];

                // 선분 A: (x1, 0) to (x2, 1)
                // 선분 B: (y1, 0) to (y2, 1)

                // 선분 A와 선분 B의 기울기
                double inc1 = (1.0) / (x2 - x1);
                double inc2 = (1.0) / (y2 - y1);

                // 교차점 계산
                double compare = (inc2 * y1 - inc1 * x1) / (inc2 - inc1);

                // 교차점이 선분 A의 범위 내에 있는지 확인
                if (x1 <= compare && compare <= x2) {
                    isSpecial = false;
                    break;
                }
            }

            if (isSpecial) {
                count++;
            }
        }

        System.out.println(count);
    }
}