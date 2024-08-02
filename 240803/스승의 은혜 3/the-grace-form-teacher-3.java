import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] students = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int maxStudents = 0;
        
        for (int i = 0; i < N; i++) {
            // i번째 학생의 선물을 반값으로 구매
            int discountCost = (students[i][0] / 2) + students[i][1];
            
            // i번째 학생을 포함한 비용 계산
            int totalCost = discountCost;
            List<Integer> otherCosts = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    otherCosts.add(students[j][0] + students[j][1]);
                }
            }
            Collections.sort(otherCosts);
            
            int count = 1; // i번째 학생을 포함하므로 1부터 시작
            for (int cost : otherCosts) {
                if (totalCost + cost <= B) {
                    totalCost += cost;
                    count++;
                } else {
                    break;
                }
            }
            
            maxStudents = Math.max(maxStudents, count);
        }
        
        System.out.println(maxStudents);
    }
}