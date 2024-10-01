import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] white = new int[200001];
        int[] black = new int[200001];
        String[] currColor = new String[200001];
        for (int i = 0; i < currColor.length; i++) {
            currColor[i] = "non";
        }

        int curr = 100000;
        int n = Integer.parseInt(br.readLine());
        int ansW=0;
        int ansB=0;
        int ansG=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            for(int j=0;j<move;j++){
                if(dir.equals("L")){
                    if(currColor[curr].equals("gray")){

                    }else{
                        currColor[curr]="white";
                        white[curr]++;
                        if(white[curr]>=2 && black[curr]>=2){
                            currColor[curr]="gray";
                        }
                    }
                    curr--;
                }
                if(dir.equals("R")){
                    if(currColor[curr].equals("gray")){

                    }else{
                        currColor[curr]="black";
                        black[curr]++;  
                        if(white[curr]>=2 && black[curr]>=2){
                            currColor[curr]="gray";
                        }
                    }
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
        for(int i=0;i<currColor.length;i++){
            if(currColor[i].equals("white")){
                ansW++;
            }
            if(currColor[i].equals("black")){
                ansB++;
            }
            if(currColor[i].equals("gray")){
                ansG++;
            }
        }

        System.out.println(ansW+" "+ansB+" "+ansG);
    }
}