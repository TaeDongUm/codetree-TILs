import java.io.*;
import java.util.*;

public class Main {
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int inputLazerR=0;
    static int inputLazerC=0;
    static int[][] visited, index;
    static int size,N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        char[][] input = new char[N][N];
        size= N+2;
        index = new int[size][size];
        visited = new int[size][size];
        visited[0][0] =1;       

        for(int i=0;i<N;i++){
            String inputLine = br.readLine();
            for(int j=0;j<N;j++){
                input[i][j] = inputLine.charAt(j);
            }
        }
        int K = Integer.parseInt(br.readLine());
        inputPosition(K);
        // System.out.println(inputLazerR+" "+inputLazerC+" check");
        System.out.println(lazerDir(inputLazerR, inputLazerC, input));

    }
    public static void inputPosition(int inputNum){
        int currR = 0;
        int currC = 0;
        int dir = 0;
        
        for(int num=1;num<=4*(size-1);num++){
            int nextR = currR + dr[dir];
            int nextC = currC + dc[dir];
            if(!indexCheck(nextR, nextC)){
                num--;
            }       
            if(isSatisfied(nextR, nextC)){
                if(num==inputNum){
                    inputLazerR = nextR;
                    inputLazerC = nextC;
                    return;
                }
                currR = nextR;
                currC = nextC;
                index[currR][currC]=num;
                continue;
            }else{
                dir = (dir + 1) % 4;            
            }
        }         
        
    }
    public static boolean indexCheck(int r, int c){
        if(r==0 && c==0) return false;
        if(r==0 && c==size-1) return false;
        if(r==size-1 && c==0) return false;
        if(r==size-1 && c==size-1) return false;
        return true;
    }
    public static boolean isSatisfied(int r, int c){
        if(!(r>=0 && r<N && c>=0 && c<N)) return false;
        if(visited[r][c] ==1) return false;
        return true;
    }
    public static int lazerDir(int r, int c, char[][] input){
        int answer=0;
        int dir=-1;
        if(r==0){
            dir=1;
            c = c-1;
            while(true){         
                dir = direction(input[r][c], dir);   
                answer++;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(isRange(nr, nc)){
                    r = nr;
                    c = nc;
                }else{
                    break;
                }
            }
        }
        else if(c==0){
            dir=0;
            r=r-1;
            while(true){         
                dir = direction(input[r][c], dir);   
                answer++;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(isRange(nr, nc)){
                    r = nr;
                    c = nc;
                }else{
                    break;
                }
            }

        }
        else if(r==N-1){
            dir=3;
            c=c-1;
            r=r-2;
            while(true){         
                dir = direction(input[r][c], dir);   
                answer++;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(isRange(nr, nc)){
                    r = nr;
                    c = nc;
                }else{
                    break;
                }
            }

        }
        else if(c==N-1){
            dir=2;
            r=r-1;
            c=c-2;
            while(true){         
                dir = direction(input[r][c], dir);   
                answer++;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(isRange(nr, nc)){
                    r = nr;
                    c = nc;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
    public static boolean isRange(int r, int c){
        if(!(r>=0 && r<N && c>=0 && c<N)) return false;
        return true;
    }
    public static int direction(char c, int dir){
        if(c=='\\'){
            if(dir==0){                
                return 1;
            }
            if(dir==1){
                return 0;
            }
            if(dir==2){
                return 3;
            }
            if(dir==3){
                return 2;
            }
        }
        if(c=='/'){
            if(dir==0){
                return 3;
            }
            if(dir==1){
                return 2;                
            }
            if(dir==2){
                return 1;
            }
            if(dir==3){
                return 0;
            }
        }
        return -1;
    }
    
}