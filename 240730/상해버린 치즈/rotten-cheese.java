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
            visited[person] =1;

            int[] cheezeCheck = new int[4];
            for(int j=0;j<list.size();j++){
                if(list.get(j)[0] == person && list.get(j)[2] < sick){
                    cheeze[list.get(j)[1]] += 1;
                    cheezeCheck[list.get(j)[1]] = 1;
                }
            }

            for(int k=0;k<cheezeCheck.length;k++){
                if(cheezeCheck[k] == 0) {
                    cheeze[k] -= 1;
                }
            }

        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)[0] == i && cheeze[list.get(j)[1]] !=0){
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