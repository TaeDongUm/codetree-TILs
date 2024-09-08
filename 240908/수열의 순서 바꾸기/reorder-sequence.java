import java.io.*;
import java.util.*;

public class Main {
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while (true) {
            if (isAlign(0, n - 1)) {  // 배열이 정렬되었는지 확인
                break;
            }

            if (num[0] == 1) {  // 첫 번째 요소가 1일 때
                for (int i = 0; i < n; i++) {
                    if (num[i] == n) {  // n을 찾으면 재배치
                        reposition(0, i);
                        answer++;
                        break;
                    }
                }
            } else if (num[0] == n) {  // 첫 번째 요소가 n일 때
                reposition(0, n - 1);  // n을 맨 뒤로 보내기
                answer++;
            } else {  // 그 외의 경우
                for (int i = 1; i < n; i++) {
                    if (num[i] == num[0] - 1) {  // 앞에 있는 숫자보다 하나 작은 숫자를 찾으면
                        reposition(0, i);
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);  // 정답 출력
    }

    public static void reposition(int pre, int move) {
        int tmpNum = num[pre];
        for (int i = pre + 1; i <= move; i++) {
            num[i - 1] = num[i];
        }
        num[move] = tmpNum;
    }

    public static boolean isAlign(int start, int end) {
        for (int i = start; i < end; i++) {
            if (num[i + 1] - num[i] != 1) {
                return false;
            }
        }
        return true;
    }
}