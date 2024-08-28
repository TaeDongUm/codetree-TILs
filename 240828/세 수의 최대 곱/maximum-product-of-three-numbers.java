import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 정수 n을 입력받음
        int n = scanner.nextInt();

        // 두 번째 줄에서 n개의 정수를 입력받아 배열에 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        // 두 가지 경우를 고려:
        // 1. 가장 큰 세 숫자의 곱
        int case1 = arr[n - 1] * arr[n - 2] * arr[n - 3];
        // 2. 가장 작은 두 숫자(음수)와 가장 큰 숫자의 곱
        int case2 = arr[0] * arr[1] * arr[n - 1];

        // 이 두 경우 중 더 큰 값을 출력
        int maxProduct = Math.max(case1, case2);
        System.out.println(maxProduct);

        scanner.close();
    }
}