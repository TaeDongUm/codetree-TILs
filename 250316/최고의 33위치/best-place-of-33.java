import java.util.Scanner;
public class Main {
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        bruteforce(grid);
        System.out.println(answer);
    }

    public static void bruteforce(int[][] grid){
        for(int i=0;i<=grid.length-3;i++){
            for(int j=0;j<=grid[i].length-3;j++){
                int countCoins=0;
                for(int m=i;m<=i+2;m++){
                    for(int n=j;n<=j+2;n++){
                        if(grid[m][n] == 1)countCoins++;
                    }
                }
                if(answer < countCoins){
                    answer = countCoins;
                }
            }
        }
    }
}