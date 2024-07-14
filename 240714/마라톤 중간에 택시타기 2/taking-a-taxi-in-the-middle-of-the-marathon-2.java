import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        String[] index = new String[2];
        LinkedList<int[]> list = new LinkedList<>();
        LinkedList<int[]> checkP = new LinkedList<>();
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        for(int i=1;i<list.size()-1;i++){
            checkP = checkPoint(list, i);
            min =Math.min(min, distanceCal(checkP));
        }
        System.out.println(min);
    }
    public static LinkedList<int[]> checkPoint(LinkedList<int[]> list, int index){
        LinkedList<int[]> tmp = new LinkedList<>();
        for(int i=0;i<list.size();i++){
            if(i==index)continue;
            tmp.add(list.get(i));
        }
        return tmp;
    }
    public static int distanceCal(LinkedList<int[]> list){
        int sum=0;
        for(int i=0;i<list.size()-1;i++){
            sum += Math.abs(list.get(i)[0]-list.get(i+1)[0]) + Math.abs(list.get(i)[1] - list.get(i+1)[1]);
        }
        return sum;
    }
}