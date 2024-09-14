import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] people = new int[N];
        int[] infection = new int[N];
        people[P-1] =1;
        infection[P-1] = K;

        LinkedList<int[]> shakeHandsList = new LinkedList<>();

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            shakeHandsList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
        }

        Collections.sort(shakeHandsList, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int infection1=0;
        int infection2=0;
        for(int i=0;i<shakeHandsList.size();i++){
            // 전염 횟수 카운트
            if(people[shakeHandsList.get(i)[1]] == 1 && infection[shakeHandsList.get(i)[1]] != 0){
                infection[shakeHandsList.get(i)[1]]--;
                infection1 = 1;
            }
            if(people[shakeHandsList.get(i)[2]] == 1 && infection[shakeHandsList.get(i)[2]] != 0){
                infection[shakeHandsList.get(i)[2]]--;
                infection2 = 1;
            }

            // 상대방 전염시키기
            if(infection1 == 1 && people[shakeHandsList.get(i)[2]] == 0){
                people[shakeHandsList.get(i)[2]] = 1;
                infection[shakeHandsList.get(i)[2]] = K;
            }
            if(infection2 == 1 && people[shakeHandsList.get(i)[1]] == 0){
                people[shakeHandsList.get(i)[1]] = 1;
                infection[shakeHandsList.get(i)[1]] = K;
            }
            infection1 = 0;
            infection2 = 0;

        }

        for(int i=0;i<people.length;i++){
            System.out.print(people[i]);
        }
    }
}