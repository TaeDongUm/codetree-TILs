import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrX = new int[11];
        int[] arrY = new int[11];
        visited = new int[11];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrX[x] += 1;
            arrY[y] += 1;

        }
        int count =N;

        for(int j=0;j<3;j++){
            int[] maxX = maxIdx(arrX);
            int[] maxY = maxIdx(arrY);
            if(maxX[0] >= maxY[0]){
                visited[maxX[1]] =1;
                count -= maxX[0];
            }else if(maxY[0] >= maxX[0]){
                visited[maxY[1]] =1;
                count -= maxY[0];
            }
        }
        if(count >0) System.out.println(0);
        else System.out.println(1);
    }
    public static int[] maxIdx(int[] num){
        int max = 0;
        int idx = 0;
        for(int i=0;i<num.length;i++){
            if(max < num[i] && visited[i] !=1){
                max = num[i];
                idx = i;
            }

        }
        int[] valueIdx = new int[]{max, idx};
        return valueIdx;
    }

}