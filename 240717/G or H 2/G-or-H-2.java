import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] positions = new int[N];
        char[] alphabets = new char[N];
        
        for (int i = 0; i < N; i++) {
            positions[i] = sc.nextInt();
            alphabets[i] = sc.next().charAt(0);
        }

        // 위치에 따라 정렬
        List<Pair> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            people.add(new Pair(positions[i], alphabets[i]));
        }
        Collections.sort(people, Comparator.comparingInt(p -> p.position));

        // 최대 크기 계산
        int maxPhotoSize = 0;
        for (int start = 0; start < N; start++) {
            int gCount = 0;
            int hCount = 0;
            for (int end = start; end < N; end++) {
                if (people.get(end).alphabet == 'G') {
                    gCount++;
                } else {
                    hCount++;
                }

                if (gCount == hCount || gCount == 0 || hCount == 0) {
                    int photoSize = people.get(end).position - people.get(start).position;
                    if (end != start) {
                        maxPhotoSize = Math.max(maxPhotoSize, photoSize);
                    }
                }
            }
        }

        System.out.println(maxPhotoSize);
    }

    static class Pair {
        int position;
        char alphabet;

        Pair(int position, char alphabet) {
            this.position = position;
            this.alphabet = alphabet;
        }
    }
}