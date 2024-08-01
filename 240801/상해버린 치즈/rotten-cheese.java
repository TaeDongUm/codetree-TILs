import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        LinkedList<int[]> list = new LinkedList<>();
        int[][] checkPeople = new int[M][N];
        int[] visited = new int[N];
        int[] cheeze = new int[M];

        for(int i=0;i<D;i++){
            st =new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken())-1;
            arr[1] = Integer.parseInt(st.nextToken())-1;
            arr[2] = Integer.parseInt(st.nextToken());

            list.add(arr);
        }

        for(int i=0;i<S;i++){
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken())-1;
            int sick = Integer.parseInt(st.nextToken());

            // 아프다고 한 사람 visited 배열로 체크하기
            // S값으로 주어진 사람들만 상한 치즈 카운팅 하기
            visited[person] =1;

            int[] cheezeCheck = new int[M];
            for(int j=0;j<list.size();j++){
                if(list.get(j)[0] == person && list.get(j)[2] < sick && list.get(j)[1] < M && cheezeCheck[list.get(j)[1]]==0){
                    checkPeople[list.get(j)[1]][person] =1;
                    cheeze[list.get(j)[1]] += 1;
                    cheezeCheck[list.get(j)[1]] = 1;
                }
            }
        }

        // S값으로 주어지지 않은 사람들 상한 치즈 카운팅 하기
        for(int i=0;i<visited.length;i++){
            int[] cheezeCheck = new int[M];
            if(visited[i] == 0){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)[0] == i && cheezeCheck[list.get(j)[1]] ==0 && list.get(j)[1] < M ){
                        checkPeople[list.get(j)[1]][i] =1;
                        cheeze[list.get(j)[1]] +=1;
                        cheezeCheck[list.get(j)[1]] =1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;

        // 각 치즈가 입력값인 아픈 사람들을 포함하는지 확인하기
        for(int i=0;i<cheeze.length;i++){
            boolean isTrue = false;
            for(int k=0;k<visited.length;k++){
                for(int j=0;j<checkPeople[i].length;j++){
                    if(visited[k] ==0) continue;
                    if(visited[k] == checkPeople[i][j] ) isTrue = true;
                }
            }
            if(isTrue){
                if(answer < cheeze[i]) answer = cheeze[i];
            }
        }
        System.out.println(answer);
        
    }
}