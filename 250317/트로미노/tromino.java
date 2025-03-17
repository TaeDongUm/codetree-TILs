import java.util.Scanner;

public class Main {
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        countingSumRightAngle(grid);
        countingSumRectangle(grid);
        System.out.println(answer);
    }

    public static void countingSumRightAngle(int[][] grid){        
        for(int i=0;i<=grid.length-2;i++){
            for(int j=0;j<=grid[i].length-2;j++){
                int numberSum=0;
                numberSum+=grid[i][j] + grid[i][j+1] + grid[i+1][j] + grid[i+1][j+1];
                for(int m=i;m<=i+1;m++){
                    for(int n=j;n<=j+1;n++){
                        if(answer < numberSum - grid[m][n]){
                        answer = numberSum - grid[m][n];
                        }
                    }
                }                
            }
        }

    }

    public static void countingSumRectangle(int[][] grid){
        for(int i=0;i<grid.length;i++){            
            for(int j=0;j<=grid[i].length-3;j++){
                int tmpSum=0;
                tmpSum+=grid[i][j] + grid[i][j+1] + grid[i][j+2];
                if(answer < tmpSum) answer = tmpSum;                
            }
        }
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<=grid.length-3;i++){
                int tmpSum =0;
                tmpSum += grid[i][j] + grid[i+1][j] + grid[i+2][j];
                if(answer < tmpSum) answer = tmpSum;
            }
        }
    }
}