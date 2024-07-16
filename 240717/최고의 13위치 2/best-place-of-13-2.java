import java.io.*;
import java.util.*;

public class Main {
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

        LinkedList<Integer> maxCoins = new LinkedList<>();

        for(int i=0;i<N;i++){
            int coins=0;
            for(int j=0;j<N;j++){
                if(j+2 < N){
                    coins += coinsMap[i][j] + coinsMap[i][j+1] + coinsMap[i][j+2];
                    maxCoins.add(coins);
                    coins=0;
                    j = j+2;
                }
            }
        }
        Collections.sort(maxCoins, Collections.reverseOrder());
        int answer = maxCoins.get(0) + maxCoins.get(1);
        System.out.println(answer);
    }
}