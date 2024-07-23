import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Question> questions = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int oneCount = Integer.parseInt(st.nextToken());
            int twoCount = Integer.parseInt(st.nextToken());
            questions.add(new Question(number, oneCount, twoCount));
        }
        
        int possibleCount = 0;
        
        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i)) {
                boolean isValid = true;
                
                for (Question q : questions) {
                    if (!isValidCount(i, q)) {
                        isValid = false;
                        break;
                    }
                }
                
                if (isValid) {
                    possibleCount++;
                }
            }
        }
        
        System.out.println(possibleCount);
    }
    
    static class Question {
        int number;
        int oneCount;
        int twoCount;
        
        Question(int number, int oneCount, int twoCount) {
            this.number = number;
            this.oneCount = oneCount;
            this.twoCount = twoCount;
        }
    }
    
    public static boolean isValidNumber(int num) {
        String s = String.valueOf(num);
        if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2)) {
            return false;
        }
        if (s.contains("0")) {
            return false;
        }
        return true;
    }
    
    public static boolean isValidCount(int candidate, Question q) {
        String cand = String.valueOf(candidate);
        String guess = String.valueOf(q.number);
        
        int oneCount = 0;
        int twoCount = 0;
        
        for (int i = 0; i < 3; i++) {
            if (cand.charAt(i) == guess.charAt(i)) {
                oneCount++;
            } else if (guess.contains(String.valueOf(cand.charAt(i)))) {
                twoCount++;
            }
        }
        
        return oneCount == q.oneCount && twoCount == q.twoCount;
    }
}