import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int maxCoins = 0;

        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                positions.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < positions.size(); i++) {
            int[] first = positions.get(i);
            for (int j = i + 1; j < positions.size(); j++) {
                int[] second = positions.get(j);

                if (!isOverlapping(first, second)) {
                    int coins = countCoins(grid, first) + countCoins(grid, second);
                    maxCoins = Math.max(maxCoins, coins);
                }
            }
        }

        System.out.println(maxCoins);
    }

    private static int countCoins(int[][] grid, int[] pos) {
        int coins = 0;
        int row = pos[0];
        int col = pos[1];
        for (int i = col; i < col + 3; i++) {
            coins += grid[row][i];
        }
        return coins;
    }

    private static boolean isOverlapping(int[] pos1, int[] pos2) {
        int row1 = pos1[0];
        int col1 = pos1[1];
        int row2 = pos2[0];
        int col2 = pos2[1];

        if (row1 != row2) {
            return false;
        }
  
        return (col1 <= col2 && col2 <= col1 + 2) || (col2 <= col1 && col1 <= col2 + 2);
    }
}