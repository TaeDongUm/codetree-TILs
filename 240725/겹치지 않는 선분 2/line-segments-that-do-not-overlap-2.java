import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        LinkedList<double[]> list = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            double[] value = new double[3];
            double x1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double incli = (double)(-1)/(x1-x2);            
            value[0] = x1;
            value[1] = x2;
            value[2] = incli;
            list.add(value);

        }
        int answer=N;        

        for(int i=0;i<list.size();i++){
            double start1 = list.get(i)[0];
            double end1 = list.get(i)[1];
            double inc1 = list.get(i)[2];
            // (inc2-inc1)*x = (inc2*start2+inc1*start1)
            boolean isTrue = true;
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                double start2 = list.get(j)[0];
                double end2 = list.get(j)[1];
                double inc2 = list.get(j)[2];
                double compare = (inc2*start2 - inc1*start1)/(inc2-inc1);
                if((start1 <=compare && compare <= end1) || (end1 <=compare && compare <= start1)) isTrue = false;
            }
            if(!isTrue) answer--;
        }        
        System.out.println(answer);
        
    }
}