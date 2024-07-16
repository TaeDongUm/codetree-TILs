import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        
        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            int guess = Integer.parseInt(input[0]);
            int count1 = Integer.parseInt(input[1]);
            int count2 = Integer.parseInt(input[2]);
            queries.add(new int[] {guess, count1, count2});
        }
        
        int possibleNumbers = 0;
        
        for (int num = 123; num <= 987; num++) {
            if (isValidNumber(num) && matchesAllQueries(num, queries)) {
                possibleNumbers++;
            }
        }
        
        System.out.println(possibleNumbers);
    }
    
    public static boolean isValidNumber(int num) {
        String str = Integer.toString(num);
        if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
            return false;
        }
        if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) {
            return false;
        }
        return true;
    }
    
    public static boolean matchesAllQueries(int num, List<int[]> queries) {
        for (int[] query : queries) {
            int guess = query[0];
            int count1 = query[1];
            int count2 = query[2];
            if (!matchesQuery(num, guess, count1, count2)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean matchesQuery(int num, int guess, int count1, int count2) {
        String numStr = Integer.toString(num);
        String guessStr = Integer.toString(guess);
        
        int actualCount1 = 0;
        int actualCount2 = 0;
        
        for (int i = 0; i < 3; i++) {
            if (numStr.charAt(i) == guessStr.charAt(i)) {
                actualCount1++;
            } else if (numStr.contains(Character.toString(guessStr.charAt(i)))) {
                actualCount2++;
            }
        }
        
        return actualCount1 == count1 && actualCount2 == count2;
    }
}