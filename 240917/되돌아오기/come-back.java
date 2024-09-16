import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int startX =0;
        int startY =0;
        int answer=0;
        int everyCount=0;
        boolean isAnswer= false;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int move = Integer.parseInt(st.nextToken());

            if(dir.equals("N")){
                for(int j=0;j<move;j++){                    
                    startY = startY + 1;
                    everyCount++;
                    if(check(startX, startY)){
                        isAnswer = true;
                        answer = everyCount;
                        break;
                    }
                }
            }
            
            if(dir.equals("E")){
                for(int j=0;j<move;j++){                    
                    startX = startX + 1;
                    everyCount++;
                    if(check(startX, startY)){
                        isAnswer = true;
                        answer = everyCount;
                        break;
                    }
                }
            }
            
            if(dir.equals("S")){
                for(int j=0;j<move;j++){                    
                    startY = startY - 1;
                    everyCount++;
                    if(check(startX, startY)){
                        isAnswer = true;
                        answer = everyCount;
                        break;
                    }
                }
            }
            
            if(dir.equals("W")){
                for(int j=0;j<move;j++){                    
                    startX = startX - 1;
                    everyCount++;
                    if(check(startX, startY)){
                        isAnswer = true;
                        answer = everyCount;
                        break;
                    }
                }
            }

            if(isAnswer) break;
        }
        if(isAnswer){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }       

    }
    public static boolean check(int x, int y){
        if(x==0 && y ==0){
            return true;
        }
        return false;
    }
}