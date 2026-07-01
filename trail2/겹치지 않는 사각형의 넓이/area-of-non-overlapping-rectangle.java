import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        int[][] coordinate = new int[2001][2001];
        int area = 0;

        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());

            int ax1 = Integer.parseInt(st.nextToken()) + 1000;
            int ay1 = Integer.parseInt(st.nextToken()) + 1000;
            int ax2 = Integer.parseInt(st.nextToken()) + 1000;
            int ay2 = Integer.parseInt(st.nextToken()) + 1000;

            for(int j=ax1; j<ax2;j++) {

                for(int k=ay1; k<ay2; k++) {
                    coordinate[j][k] = 1;       
                    area++;         
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int ax1 = Integer.parseInt(st.nextToken()) + 1000;
        int ay1 = Integer.parseInt(st.nextToken()) + 1000;
        int ax2 = Integer.parseInt(st.nextToken()) + 1000;
        int ay2 = Integer.parseInt(st.nextToken()) + 1000;

        for(int i=ax1; i<ax2; i++) {

            for(int j=ay1;j<ay2;j++) {
                if(coordinate[i][j]==1) {
                    area--;
                }

            }
        }

        // for(int i=0;i<2001;i++) {
        //     for(int j=0;j<2001;j++) {
        //         if(coordinate[i][j]==1) {
        //             area++;
        //         }
        //     }
        // }

        System.out.println(area);

    }
}