import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] abilities = new int[6];
        
        for (int i = 0; i < 6; i++) {
            abilities[i] = sc.nextInt();
        }
        
        int minDifference = Integer.MAX_VALUE;        

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < 6; l++) {
                        if (l == i || l == j) continue;
                        for (int m = 0; m < 6; m++) {
                            if (m == i || m == j || m == k || m == l) continue;
                            for (int n = m + 1; n < 6; n++) {
                                if (n == i || n == j || n == k || n == l) continue;
                                
                                // 각 팀의 합을 계산
                                int team1 = abilities[i] + abilities[j];
                                int team2 = abilities[k] + abilities[l];
                                int team3 = abilities[m] + abilities[n];
                                
                                // 최대 팀과 최소 팀의 차이를 계산
                                int maxSum = Math.max(team1, Math.max(team2, team3));
                                int minSum = Math.min(team1, Math.min(team2, team3));
                                
                                // 차이를 최소화
                                int difference = maxSum - minSum;
                                minDifference = Math.min(minDifference, difference);
                            }
                        }
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.println(minDifference);
    }
}