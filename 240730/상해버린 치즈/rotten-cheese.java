import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<int[]> list = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int[] sickTime = new int[N];
        Arrays.fill(sickTime, Integer.MAX_VALUE);

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken()) - 1;
            arr[1] = Integer.parseInt(st.nextToken()) - 1;
            arr[2] = Integer.parseInt(st.nextToken());
            list.add(arr);
        }

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken()) - 1;
            int sick = Integer.parseInt(st.nextToken());
            visited[person] = true;
            sickTime[person] = sick;
        }

        int maxMedicinesNeeded = 0;

        for (int m = 0; m < M; m++) {
            boolean possible = true;
            Set<Integer> sickPeople = new HashSet<>();

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    boolean found = false;
                    for (int[] record : list) {
                        if (record[0] == i && record[1] == m && record[2] < sickTime[i]) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                for (int[] record : list) {
                    if (record[1] == m) {
                        sickPeople.add(record[0]);
                    }
                }
                maxMedicinesNeeded = Math.max(maxMedicinesNeeded, sickPeople.size());
            }
        }

        System.out.println(maxMedicinesNeeded);
    }
}