import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 처리
        int N = scanner.nextInt();
        String seats = scanner.next();
        
        int maxDistance = 0;
        int prevOccupied = -1;
        
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == '1') {
                if (prevOccupied == -1) {
                    // 처음으로 사람이 앉아있는 자리의 앞쪽 거리 처리
                    maxDistance = i;
                } else {
                    // 두 사람이 앉아있는 자리 사이의 거리의 반을 계산
                    maxDistance = Math.max(maxDistance, (i - prevOccupied) / 2);
                }
                prevOccupied = i;
            }
        }
        
        // 마지막으로 사람이 앉아있는 자리의 뒤쪽 거리 처리
        maxDistance = Math.max(maxDistance, N - 1 - prevOccupied);
        
        System.out.println(maxDistance);
    }
}