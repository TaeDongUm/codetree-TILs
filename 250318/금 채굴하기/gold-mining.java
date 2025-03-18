import java.util.Scanner;

public class Main {
    static int answer=0;
    static int[] dr1 = {-1,1,0,0};
    static int[] dc1 = {0,0,-1,1};
    static int[] dr2 = {-1,-1,1,1};
    static int[] dc2 = {-1,1,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        countGold(grid, n, m);
        System.out.println(answer);
    }
    public static void countGold(int[][] grid, int size, int m){
        int k=0;
        while(k <= size){            
            for(int r=0;r<size;r++){
                for(int c=0;c<size;c++){
                    int goldCount=0;
                    if(grid[r][c]==1) goldCount++;
                    if(k==0) continue;
                    for(int d=1;d<=k;d++){
                        for(int l=0;l<4;l++){
                            int e = d-1;
                            int nr1 = r + dr1[l]*d;
                            int nc1 = c + dc1[l]*d;
                            int nr2 = r + dr2[l]*e;
                            int nc2 = c + dc2[l]*e;
                            if(nr1>=0 && nr1<size && nc1>=0 && nc1<size && !(nr1 == r && nc1 == c)){
                                if(grid[nr1][nc1] ==1){
                                    goldCount++;
                                }
                            }
                            if(nr2>=0 && nr2<size && nc2>=0 && nc2<size && !(nr2 == r && nc2 == c)){
                                if(grid[nr2][nc2] ==1){
                                    goldCount++;
                                }
                            }
                        }
                    }
                    if(goldCount*m >= k*k+(k+1)*(k+1)){
                        if(answer < goldCount) answer = goldCount;
                    }


                }
            }
            k++;
        }
    }
}