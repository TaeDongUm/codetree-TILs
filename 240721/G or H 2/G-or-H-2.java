import java.io.*;
import java.util.*;

public class Main{
    static int dist = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Pair> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.index - o2.index;
            }
        });

        for(int i=0;i<N;i++){
            int gCount=0;
            int hCount=0;
            int startDist=0;
            if(list.get(i).gorH.equals("G")){
                gCount++;
                startDist = list.get(i).index;

            }else{
                hCount++;
                startDist = list.get(i).index;
            }
            for(int j=i+1;j<N;j++){
                if(list.get(j).gorH.equals("G")){
                    gCount++;
                }else{
                    hCount++;
                }
                if(gCount == hCount || gCount ==0 || hCount == 0){
                    int tmp = Math.abs(startDist - list.get(j).index);
                    if( tmp > dist){
                        dist = tmp;
                    }
                }
            }
        }
        System.out.println(dist);

    }

}
class Pair{
    int index;
    String gorH;

    Pair(int index, String gorH) {
        this.index = index;
        this.gorH = gorH;
    }
}