import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 처리
        int N = scanner.nextInt();
        String seats = scanner.next();
        
        int maxMinDistance = 0;

        // 각 빈자리('0')에 대해 사람을 배치했을 때 최소 거리를 계산
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == '0') {
                int leftDistance = Integer.MAX_VALUE;
                int rightDistance = Integer.MAX_VALUE;
                
                // 왼쪽으로 가장 가까운 '1'의 거리 계산
                for (int j = i - 1; j >= 0; j--) {
                    if (seats.charAt(j) == '1') {
                        leftDistance = i - j;
                        break;
                    }
                }
                
                // 오른쪽으로 가장 가까운 '1'의 거리 계산
                for (int j = i + 1; j < N; j++) {
                    if (seats.charAt(j) == '1') {
                        rightDistance = j - i;
                        break;
                    }
                }
                
                // 현재 빈자리에 사람을 배치했을 때의 최소 거리 계산
                int minDistance = Math.min(leftDistance, rightDistance);
                
                // 그 거리 중 최댓값을 갱신
                maxMinDistance = Math.max(maxMinDistance, minDistance);
            }
        }
        
        // 결과 출력
        System.out.println(maxMinDistance);
    }
}