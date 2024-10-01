import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] white = new int[200001];
        int[] black = new int[200001];
        // String[] currColor = new String[200001];
        int[] colorList = new int[200001];
        // for (int i = 0; i < currColor.length; i++) {
        //     currColor[i] = "non";
        // }

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
                    // if(currColor[curr].equals("gray")){
                    if(colorList[curr]==3){
                    }else{
                        // currColor[curr]="white";
                        colorList[curr]=1;
                        white[curr]++;
                        if(white[curr]>=2 && black[curr]>=2){
                            // currColor[curr]="gray"; 
                            colorList[curr]=3;
                        }
                    }
                    curr--;
                }
                if(dir.equals("R")){
                    // if(currColor[curr].equals("gray")){
                    if(colorList[curr]==3){
                    }else{
                        // currColor[curr]="black";
                        colorList[curr]=2;
                        black[curr]++;  
                        if(white[curr]>=2 && black[curr]>=2){
                            // currColor[curr]="gray";
                            colorList[curr]=3;
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
        // for(int i=0;i<currColor.length;i++){
        //     if(currColor[i].equals("white")){
        //         ansW++;
        //     }
        //     if(currColor[i].equals("black")){
        //         ansB++;
        //     }
        //     if(currColor[i].equals("gray")){
        //         ansG++;
        //     }
        // }
        for(int i=0;i<colorList.length;i++){
            if(colorList[i]==1){
                ansW++;
            }
            if(colorList[i]==2){
                ansB++;
            }
            if(colorList[i]==3){
                ansG++;
            }
        }

        System.out.println(ansW+" "+ansB+" "+ansG);
    }
}