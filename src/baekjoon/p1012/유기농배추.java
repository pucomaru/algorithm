package baekjoon.p1012;

import java.io.*;
import java.util.*;

public class 유기농배추 {

    static BufferedReader br;
    static StringTokenizer st;
    static int tc;
    static int M,N,K;
    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            // 가로
            M = Integer.parseInt(st.nextToken());
            // 세로
            N = Integer.parseInt(st.nextToken());
            // 배추가 심어져 있는 위치 개수
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K ; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            int count =0 ;
            for (int r = 0; r < N  ; r++){
                for (int c = 0; c < M ; c++){
                    if (field[r][c] == 1 && !visited[r][c]) {
                        bfs(r,c);
                        count ++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void bfs(int nowR, int nowC){
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{nowR,nowC});

        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};

        while(!q.isEmpty()){
            int[] now = q.poll();
            nowR = now[0];
            nowC = now[1];
            for(int i = 0; i < 4; i++){
                int ny = nowR + dy[i];
                int nx = nowC + dx[i];
                if (ny < 0 || ny >= N  || nx < 0 || nx >= M ) continue;
                if (field[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
        }

    }
}
