import java.io.*;
import java.util.*;

public class Main {
    static int[] dr={0,1,0,-1}; // 우, 하, 좌, 상
    static int[] dc={1,0,-1,0};
    static int N;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int K = Integer.parseInt(br.readLine());
        
        // 레이저 발사 위치와 방향 설정
        int r = 0, c = 0, dir = 0;
        if (K <= N) {
            r = 0; c = K - 1; dir = 1; // 상단에서 시작 -> 아래 방향
        } else if (K <= 2 * N) {
            r = K - N - 1; c = N - 1; dir = 2; // 우측에서 시작 -> 왼쪽 방향
        } else if (K <= 3 * N) {
            r = N - 1; c = 3 * N - K; dir = 3; // 하단에서 시작 -> 위쪽 방향
        } else {
            r = 4 * N - K; c = 0; dir = 0; // 좌측에서 시작 -> 오른쪽 방향
        }

        int answer = simulateLaser(r, c, dir, map);
        System.out.println(answer);
    }

    public static int simulateLaser(int r, int c, int dir, char[][] map) {
        int count = 0;

        while (true) {
            // 레이저가 맵을 벗어나면 종료
            if (r < 0 || r >= N || c < 0 || c >= N) break;

            // 현재 위치에서 거울을 만났을 때 방향 변경
            if (map[r][c] == '/') {
                dir = (dir == 0) ? 3 : (dir == 1) ? 2 : (dir == 2) ? 1 : 0;
            } else if (map[r][c] == '\\') {
                dir = (dir == 0) ? 1 : (dir == 1) ? 0 : (dir == 2) ? 3 : 2;
            }

            // 방향에 따라 이동
            r += dr[dir];
            c += dc[dir];
            count++;
        }

        return count;
    }
}