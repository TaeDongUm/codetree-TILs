import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"};

        int dateDiff = calculateDateDiff(m1, d1, m2, d2);

        int answer = 0;
        for(int i =0; i<=dateDiff; i++) {
            if(daysOfWeek[i%7].equals(A)) {
                answer++;
            }
        }

        System.out.println(answer);
        


    }

    public static int calculateDateDiff(int m1, int d1, int m2, int d2) {
        int[] daysOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int returnDiff = 0;

        int totalDate1 = 0;
        int totalDate2 = 0;
        for(int i=0;i<13;i++) {
            if(i<=m1-1) {
                totalDate1 += daysOfMonth[i];
            }
            if(i<=m2-1) {
                totalDate2 += daysOfMonth[i];
            }
        }

        returnDiff = totalDate2 + d2 - (totalDate1  + d1);
        return returnDiff;
    }
}