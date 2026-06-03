import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int binaryToInt = 0;

        for(int i=0;i<binary.length();i++) {
            int temp = Character.getNumericValue(binary.charAt(i));
            binaryToInt = binaryToInt*2 + temp;
        }

        binaryToInt = binaryToInt*17;

        List<Integer> digits = new ArrayList<>();

        while(true) {
            if(binaryToInt < 2) {
                digits.add(binaryToInt);
                break;
            }

            digits.add(binaryToInt % 2);
            binaryToInt = binaryToInt/2;
        }

        for(int i=digits.size()-1;i>=0;i--) {
            System.out.print(digits.get(i));
        }

        
    }
}

