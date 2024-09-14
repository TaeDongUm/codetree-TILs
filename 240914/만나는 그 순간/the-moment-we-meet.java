import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Move> moveListA = new LinkedList<>();
        LinkedList<Move> moveListB = new LinkedList<>();
        int moveTime = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int move = Integer.parseInt(st.nextToken());
            moveTime += move;
            moveListA.add(new Move(dir, move));
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            moveListB.add(new Move(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        int[] moveA = new int[moveTime + 1];
        int[] moveB = new int[moveTime + 1];

        moveA[0] = 0;
        moveB[0] = 0;
        int indexA=1;
        int indexB=1;

        for(int i=0;i<moveListA.size();i++){
            Move Amove = moveListA.get(i);
            String dir = Amove.dir;
            int move = Amove.move;         
            
            while(move > 0 ){
                if(dir.equals("R")){
                    moveA[indexA] = moveA[indexA - 1] + 1;
                }
                if(dir.equals("L")){
                    moveA[indexA] = moveA[indexA - 1] - 1;
                }
                indexA++;
                move--;
            }
        }

        for(int i=0;i<moveListB.size();i++){
            Move Bmove = moveListB.get(i);
            String dir = Bmove.dir;
            int move = Bmove.move;

            while(move > 0){
                if(dir.equals("R")){
                    moveB[indexB] = moveB[indexB - 1] + 1;
                }
                if(dir.equals("L")){
                    moveB[indexB] = moveB[indexB - 1] - 1;
                }
                indexB++;
                move--;
            }
        }
        int answer=-1;
        for(int i=1;i<=moveTime;i++){
            if(moveA[i] == moveB[i]){
                answer = i;
                break;
            }
        }
        System.out.println(answer);


    }
}

class Move{
    String dir;
    int move;

    Move(String dir, int move){
        this.dir = dir;
        this.move = move;
    }
}