import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        String seats = scanner.next();
        
        int maxDistance = 0;

        // 좌석 간 사람 사이의 거리를 기록
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == '0') {
                int leftDistance = Integer.MAX_VALUE;
                int rightDistance = Integer.MAX_VALUE;
                
                // 왼쪽에서 가장 가까운 사람과의 거리 계산
                for (int j = i - 1; j >= 0; j--) {
                    if (seats.charAt(j) == '1') {
                        leftDistance = i - j;
                        break;
                    }
                }
                
                // 오른쪽에서 가장 가까운 사람과의 거리 계산
                for (int j = i + 1; j < N; j++) {
                    if (seats.charAt(j) == '1') {
                        rightDistance = j - i;
                        break;
                    }
                }
                
                // 두 사람 사이의 거리 중 최소값을 계산
                int minDistance = Math.min(leftDistance, rightDistance);
                
                // 그 중에서 최대 거리값을 갱신
                maxDistance = Math.max(maxDistance, minDistance);
            }
        }
        
        System.out.println(maxDistance);
    }
}