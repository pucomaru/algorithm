package baekjoon.p21772;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// DP로 접근했는데 틀린 접근같음
// 백트래킹
public class 가희의고구마먹방_DP틀린풀이 {

    static BufferedReader br;
    static StringTokenizer st;

    // 맵의 세로 길이
    static int R;

    // 맵의 가로 길이
    static int C;

    // 가희가 이동하는 시간
    static int T;

    // 맵
    static char[][] map;
    static int[][] dpMap;

    // 북동남서
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    // 결과값
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 맵 크기
        map = new char[R][C];
        dpMap = new int[R][C];

        // 가희 현재 위치
        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < R ; i++){
            String line = br.readLine();
            for (int j = 0; j < C; j ++){
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'G') {
                    nowX = i;
                    nowY = j;
                }
            }
        }

        result = 0;


        dp(nowX,nowY,0, 0);

        for (int i = 0; i < R ; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(dpMap[i][j]);
            }
            System.out.println();
        }


        System.out.println(result);
    }

    // 규칙
    // 1. 가희는 1초마다 상하좌우 방향 중 한 방향으로 1번 이동하거나, 이동하지 않고 그 자리에 머무를 수 있다.
    // 2. 가희가 이동한 지점에 고구마가 있는 경우에는 , 고구마를 먹음
    // 3. 가희가 고구마를 먹으면 , 고구마가 다시 그 자리에 생기지 않음
    // 최대한 많은 고구마 먹기
    // dfs하면 시간초과 해당 칸에 도착하는 최적의 시간을 dpMap에 저장해주자!
    static void dp(int y, int x, int time, int eat){
        if(time > T) {
            if (eat > result) result = eat;
            return;
        }
        else if(dpMap[y][x] > time) {
            boolean doEat = false;
            // 백트래킹 필요한 부분 여기서 먹은 처리하면 다른 경로에서는 이 칸에있는 고구마를 못먹음
            if (map[y][x] == 'S') {
                eat++;

                map[y][x] = '.';
            }
            for (int i = 0 ; i < 4 ; i ++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                // x,y가 현재 맵을 벗어나거나 이동한 곳이 막혀있으면 갈 수 없음
                if ((0 > nx) || (nx >= C) ||  (0 > ny)
                        || (ny >= R) || (map[ny][nx] == '#')) continue;
                dpMap[y][x] = time;
                dp(ny,nx,time + 1,eat);
            }

        }
    }
}
