import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        LinkedList<int[]> list = new LinkedList<>();
        int maxStudents=0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] students = new int[2];
            students[0] = Integer.parseInt(st.nextToken());
            students[1] = Integer.parseInt(st.nextToken());
            list.add(students);
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int sumA = a[0] + a[1];
                int sumB = b[0] + b[1];
                return Integer.compare(sumA, sumB);
            }
        });
        int money =0;

        for(int i=0;i<list.size();i++){
            money += list.get(i)[0] + list.get(i)[1];
            maxStudents++;
        }
        for(int i=0;i<list.size();i++){
            int tmpMoney = money - list.get(i)[0]/2; 
            int students = remove(list, i, tmpMoney, maxStudents, B);
            if(answer < students) answer = students;
        }
        System.out.println(answer);
 
    }
    public static int remove(LinkedList<int[]> list, int idx, int tmpMoney, int Students, int B){
        for(int i=list.size()-1;i>0;i--){
            if(i == idx) continue;

            tmpMoney -= list.get(i)[0] + list.get(i)[1];
            Students--;
            if(B >= tmpMoney){
                return Students;
            }
        }
        return Students;
    }
}