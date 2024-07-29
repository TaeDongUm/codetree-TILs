import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 1. 치즈 하나 상함
        // 2. 완벽하게 기록된 것 아님. 아픈 사람이 기록되지 않았을 수 있음
        // 3. 약 최대 갯수
        // 상한 치즈는 1초 후 아프기 시작함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        LinkedList<int[]> list = new LinkedList<>();
        int[] cheeze = new int[M];
        int[] visited = new int[N];

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
            visited[person] =1;

            for(int j=0;j<list.size();j++){
                if(list.get(j)[0] == person && list.get(j)[2] < sick){
                    cheeze[list.get(j)[1]] += 1;
                }
            }

        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)[0] == i){
                        cheeze[list.get(j)[1]] +=1;
                    }
                }
            }
        }
        int answer = 0;

        for(int i=0;i<cheeze.length;i++){
            answer = Math.max(cheeze[i], answer);
        }
        System.out.println(answer);


        
    }
}