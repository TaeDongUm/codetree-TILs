import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");

        int first = Integer.parseInt(num[0]);
        int mid = Integer.parseInt(num[1]);
        int end = Integer.parseInt(num[2]);
        if(mid - first > end - mid){
            System.out.println(mid-first-1);
        }else{
            System.out.println(end-mid-1);
        }
    }
}