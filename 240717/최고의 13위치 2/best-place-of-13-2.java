import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] coinsMap = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                coinsMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<LinkedList<Integer>> maxCoins = new LinkedList<>();

        for(int i=0;i<N;i++){
            int coins=0;
            for(int j=0;j<N;j++){
                if(j+2 < N){
                    coins += coinsMap[i][j] + coinsMap[i][j+1] + coinsMap[i][j+2];
                    for(int k=0;k<N;k++){
                        for(int l=0;l<N;l++){
                            if(i==k){
                                if(j+2 <l && l+2 <N){
                                    coins += coinsMap[k][l] + coinsMap[k][l+1] + coinsMap[k][l+2];                                    
                                    answer = Math.max(answer, coins);
                                    coins -= coinsMap[k][l] + coinsMap[k][l+1] + coinsMap[k][l+2];

                                }
                            }else{
                                if(l+2 < N){
                                    coins += coinsMap[k][l] + coinsMap[k][l+1] + coinsMap[k][l+2];
                                    answer = Math.max(answer, coins);
                                    coins -= coinsMap[k][l] + coinsMap[k][l+1] + coinsMap[k][l+2];
                                }
                            }

                            
                        }
                    }
                }
                coins=0;

            }
        }
        System.out.println(answer);
    }
}