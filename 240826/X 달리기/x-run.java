import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        
        int cur_pos = 0;
        int cur_speed = 1;
        int sum_time = 0;
        
        while (true) {
            cur_pos += cur_speed;
            sum_time++;
            cur_speed++;
            int increase_sum = 0;

            if (cur_pos == X) {
                break;
            }
            
            for (int i = 0; i < cur_speed; i++) {
                increase_sum += i;
            }
            if (X - (cur_pos + cur_speed) < increase_sum) {
                cur_speed--;
            }
            
            int stay_sum = 0;
            for (int i = 0; i < cur_speed; i++) {
                stay_sum += i;
            }
            if (X - (cur_pos + cur_speed) < stay_sum) {
                cur_speed--;
            }
        }

        System.out.println(sum_time);
    }
}