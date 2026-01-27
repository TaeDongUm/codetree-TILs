import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String input = sc.next();
            if(input.equals("push_back")) {
                int inputNum = Integer.parseInt(sc.next());
                list.add(inputNum);
            }
            if(input.equals("get")) {
                int inputNum = Integer.parseInt(sc.next());
                System.out.println(list.get(inputNum-1));
            }
            if(input.equals("size")) {
                System.out.println(list.size());
            }
            if(input.equals("pop_back")) {
                list.remove(list.size()-1);
            }
        }
    }
}