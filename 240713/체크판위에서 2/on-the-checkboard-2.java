import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] map = new String[R][C];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = st.nextToken();
            }
        }
        String currentPos = map[0][0];
        int currentX = 0;
        int currentY = 0;
        int count=0;
        int result = movePos(currentX, currentY, map, currentPos, count);
        System.out.println(result);


    }
    public static int movePos(int currentX, int currentY, String[][] map, String currentPos, int count){
        for(int i=currentX+1;i<map.length-1;i++){
            for(int j=currentY+1;j<map[0].length-1;j++){
                if(map[i][j].charAt(0) != currentPos.charAt(0)){
                    
                    for(int k=i+1;k<map.length-1;k++){
                        for(int l=j+1;l<map[0].length-1;l++){
                            if(map[i][j].charAt(0) != map[k][l].charAt(0) && map[k][l].charAt(0) != map[map.length-1][map[0].length-1].charAt(0)){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}