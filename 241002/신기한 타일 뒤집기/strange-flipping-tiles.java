import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1: 흰색, 2: 검은색
        int[] tile = new int[200001];
        int curr=100000;
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            for(int j=0;j<move;j++){
                if(dir.equals("L")){
                    tile[curr]=1;
                    curr--;
                }
                if(dir.equals("R")){
                    tile[curr]=2;
                    curr++;
                }
            }
            if(dir.equals("L")){
                curr++;
            }
            if(dir.equals("R")){
                curr--;
            }
        }
        int white=0;
        int black=0;
        for(int i=0;i<tile.length;i++){
            if(tile[i]==1){
                white++;
            }
            if(tile[i]==2){
                black++;
            }
        }
        System.out.println(white+" "+black);
    }
}