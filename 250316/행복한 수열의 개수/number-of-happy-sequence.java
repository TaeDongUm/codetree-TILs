import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        int answer = gridRowCount(grid, m) + gridColCount(grid, m);
        System.out.println(answer);
    }

    public static int gridRowCount(int[][] grid, int m){
        int rowCount=0;
        for(int i=0;i<grid.length;i++){
            int rowTmpCount=0;
            int tmpCount=1;
            for(int j=0;j<=grid.length-2;j++){
                if(grid[i][j] == grid[i][j+1]) tmpCount++;
                if((grid[i][j] != grid[i][j+1]) || (j==grid.length-2)){
                    rowTmpCount = Math.max(rowTmpCount, tmpCount);
                    tmpCount=1;                    
                }
            }    
            if(rowTmpCount >= m){
                rowCount++;
            }
        }
        return rowCount;
    }

    public static int gridColCount(int[][] grid, int m){
        int colCount=0;
        for(int j=0;j<grid.length;j++){
            int colTmpCount=0;
            int tmpCount=1;
            for(int i=0;i<=grid.length-2;i++){
                if(grid[i][j] == grid[i+1][j]) tmpCount++;
                if((grid[i][j] != grid[i+1][j]) || (i==grid.length-2)){
                    colTmpCount = Math.max(colTmpCount, tmpCount);
                    tmpCount=1;
                }
            }            
            if(colTmpCount >= m){
                colCount++;
            }
        }
        return colCount;
    }
}