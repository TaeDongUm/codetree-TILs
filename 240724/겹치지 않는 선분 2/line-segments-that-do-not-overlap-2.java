import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        LinkedList<float[]> list = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            float[] value = new float[3];
            float x1 = Float.parseFloat(st.nextToken());
            float x2 = Float.parseFloat(st.nextToken());
            float incli = (float)(-1)/(x1-x2);            
            value[0] = x1;
            value[1] = x2;
            value[2] = incli;
            list.add(value);

        }
        int answer=N;
        

        for(int i=0;i<list.size();i++){
            float start1 = list.get(i)[0];
            float end1 = list.get(i)[1];
            float inc1 = list.get(i)[2];
            // (inc2-inc1)*x = (inc2*start2+inc1*start1)
            boolean isTrue = true;
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                float start2 = list.get(j)[0];
                float end2 = list.get(j)[1];
                float inc2 = list.get(j)[2];
                float compare = (inc2*start2 - inc1*start1)/(inc2-inc1);
                if(start1 <=compare && compare <= end1 ) isTrue = false;
            }
            if(!isTrue) answer--;
        }        
        System.out.println(answer);
        
    }
}