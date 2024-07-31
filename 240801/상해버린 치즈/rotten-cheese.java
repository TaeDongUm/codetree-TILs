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

            int[] cheezeCheck = new int[M];
            for(int j=0;j<list.size();j++){
                if(list.get(j)[0] == person && list.get(j)[2] < sick && cheezeCheck[list.get(j)[1]]==0){
                    cheeze[list.get(j)[1]] += 1;
                    cheezeCheck[list.get(j)[1]] = 1;
                }
            }

        }

        for(int i=0;i<visited.length;i++){
            int[] cheezeCheck = new int[M];
            if(visited[i] == 0){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)[0] == i && cheezeCheck[list.get(j)[1]] ==0 ){
                        cheeze[list.get(j)[1]] +=1;
                        cheezeCheck[list.get(j)[1]] =1;
                    }
                }
            }
        }

        int answer = 0;
        // for(int i=0;i<cheeze.length;i++){
        //     int[] checkPeople = new int[N];
        //     boolean isTrue = true;
        //     for(int j=0;j<list.size();j++){
        //         if(i == list.get(j)[1] && checkPeople[list.get(j)[0]]==0){
        //             checkPeople[list.get(j)[0]] =1;
        //         }else if(i == list.get(j)[1] && checkPeople[list.get(j)[0]] !=0){
        //             cheeze[list.get(j)[1]] -=1;
        //             isTrue = false;
        //             break;
        //         } 
        //     }
        //     if(isTrue){
        //         if(answer < cheeze[i]) answer = cheeze[i];
        //     }
            
        // }        
        for(int i=0;i<cheeze.length;i++){
            answer = Math.max(answer, cheeze[i]);
        }
        System.out.println(answer);
        
    }
}