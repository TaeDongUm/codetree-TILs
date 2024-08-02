import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static int N, B;
    static int countCheck=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 1. 각 학생이 쿠폰을 받을 학생이라고 가정한다.
        // 2. dfs를 통해서 각 학생을 뺄지 포함할지 선택한다.

        LinkedList<int[]> list = new LinkedList<>();
        int[] pickStudent = new int[N];
        int money =0;
        int student = N;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            money += arr[0] + arr[1];
            list.add(arr);
        }

        // 한 학생을 쿠폰 적용 대상자로 선택
        for(int i=0;i<list.size();i++){
            int tmpMoney = money - list.get(i)[0]/2;
            pickStudent[i] = 1;
            dfs(list, student, tmpMoney, pickStudent);
            pickStudent[i] = 0;
            
        }
        System.out.println(answer);

    }
    public static void dfs(LinkedList<int[]> list, int student, int money, int[] pickStudent){
        if(B >= money){
            if(student > answer){
                answer = student;
                return;
            } 
            
        }
        for(int i=0;i<list.size();i++){
            if(pickStudent[i] == 1) continue;
            pickStudent[i] =1;
            int tmpMoney = money -(list.get(i)[0] + list.get(i)[1]);
            dfs(list, student -1, tmpMoney, pickStudent); // 해당 학생을 뺸다
            // dfs(list, student, money, pickStudent); // 해당 학생을 빼지 않는다.
            pickStudent[i] =0;

        }
    }


}