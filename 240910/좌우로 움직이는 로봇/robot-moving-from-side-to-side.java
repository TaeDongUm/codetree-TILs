import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<robotMove> moveN = new LinkedList<>();
        LinkedList<robotMove> moveM = new LinkedList<>();
        int nClockSum=0;
        int mClockSum=0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int inputMoveN= Integer.parseInt(st.nextToken());
            nClockSum += inputMoveN;
            moveN.add(new robotMove(inputMoveN, st.nextToken()));            
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int inputMoveM = Integer.parseInt(st.nextToken());
            mClockSum += inputMoveM;
            moveM.add(new robotMove(inputMoveM, st.nextToken()));
        }
        int nPos=0;
        int mPos=0;
        int remainMoveN=0;
        String nDir="";
        int remainMoveM=0;
        String mDir="";
        int clock=0;
        int clockCheck=-1;
        int answer=0;
        int goal = Math.max(nClockSum, mClockSum);
        while(clock < goal){
            if(remainMoveN==0 && !moveN.isEmpty()){
                robotMove rMoveN = moveN.poll();
                remainMoveN = rMoveN.move;
                nDir = rMoveN.dir;
            }
            if(remainMoveM==0 && !moveM.isEmpty()){
                robotMove rMoveM = moveM.poll();
                remainMoveM = rMoveM.move;
                mDir = rMoveM.dir;
            }
            clock++;
            if(remainMoveN !=0){
                if(nDir.equals("L")){
                    remainMoveN--;
                    nPos--;
                }else if(nDir.equals("R")){
                    remainMoveN--;
                    nPos++;
                }
            }

            if(remainMoveM !=0){
                if(mDir.equals("L")){
                    remainMoveM--;
                    mPos--;
                }else if(mDir.equals("R")){
                    remainMoveM--;
                    mPos++; 
                }
            }
            
            if(nPos == mPos){
                if((clock - clockCheck) !=1){
                    answer++;
                }
                clockCheck = clock;
            }          

        }
        System.out.println(answer);

    }
}
class robotMove{
    int move;
    String dir;

    robotMove(int move, String dir){
        this.move = move;
        this.dir =dir;
    }

}