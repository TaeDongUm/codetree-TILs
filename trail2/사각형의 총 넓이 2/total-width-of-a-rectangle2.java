import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[][] checked = new boolean[201][201];
        int offset = 100;

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            x1 += offset;
            y1 += offset;
            x2 += offset;
            y2 += offset;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    checked[x][y] = true;
                }
            }
        }

        int answer = 0;

        for (int x = 0; x <= 200; x++) {
            for (int y = 0; y <= 200; y++) {
                if (checked[x][y]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}