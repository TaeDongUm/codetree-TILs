import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String seat = br.readLine();
        int minValue = Integer.MAX_VALUE;
        LinkedList<maxDistance> dist = new LinkedList<>();
        for(int i=0;i<seat.length()-1;i++){
            if(seat.charAt(i)=='1'){
                for(int j=i+1;j<seat.length();j++){
                    if(seat.charAt(j)=='1'){
                        if(j-i >3){
                            minValue = Math.min(minValue, j-i);
                            dist.add(new maxDistance(i,j, j-i));
                        }
                        break;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0;i<dist.size();i++){
            int distance1=0;
            int distance2=0;
            if(dist.get(i).distance == minValue){
                int idx1 = dist.get(i).idx1;
                int idx2 = dist.get(i).idx2;

                int idx3 = (idx1 + idx2)/2;
                distance1 = idx3 - idx1;
                distance2 = idx2 - idx3;
                answer = Math.max(distance1, distance2);
            }
        }
        System.out.println(answer);
    }
}
class maxDistance{
    int idx1=0;
    int idx2=0;
    int distance=0;
    maxDistance(int idx1, int idx2, int distance){
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.distance = distance;
    }    
}