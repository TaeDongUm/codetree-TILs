import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        boolean isOverlapped = true;

        // if(x2 < a1){
        //     isOverlapped = false;
        // }
        // if(a2 < x1){
        //     isOverlapped = false;
        // }
        // if(b2 < y1){
        //     isOverlapped = false;
        // }
        // if(y2 < b1){
        //     isOverlapped =false;
        // }
        if(x2 < a1 || a2 < x1 || b2 < y1 || y2 < b1) isOverlapped = false;
        if(isOverlapped){
            System.out.println("overlapping");
        }else{
            System.out.println("nonoverlapping");
        }

    }
}