package baekjoon.p14940;

import java.io.*;
import java.util.*;
public class 쉬운최단거리 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N,M ;
    static int[][] road ;
    static int[][] bfsmap;
    static int startR,startC;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[N][M];
        bfsmap = new int[N][M];

        // Arrays.fill 쌀라면 한 행씩 이차원배열 한꺼번에 값바꾸는건안됨
        for (int i = 0 ; i < N; i++){
            Arrays.fill(bfsmap[i],-1);
        }

        for(int i=0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M ;j++) {
                int now = Integer.parseInt(st.nextToken());
                road[i][j] = now;
                if (now == 2) {
                    startR = i;
                    startC = j;
                }
                // bfs돌ㄸ ㅐ 0을 못가는 경우가 생길 수 있으니 미리 0처리
                if (now == 0) bfsmap[i][j] = 0;
            }
        }

        bfs(startR,startC);

        for(int i=0; i < N ;i++){
            for (int j=0; j < M ;j++){
                System.out.print(bfsmap[i][j]);
                if(j != M-1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void bfs(int startR,int startC){
        Queue<Now> q = new ArrayDeque<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][M];

        visited[startR][startC] =true;
        bfsmap[startR][startC] = 0;
        q.add(new Now(startR,startC));

        while (!q.isEmpty()){
            Now now = q.poll();
            int nowR = now.r;
            int nowC = now.c;
            for (int i = 0; i < 4 ; i++ ){
                int ny = nowR + dy[i];
                int nx = nowC + dx[i];
                if (ny < 0 || ny >= N || nx <0 || nx >= M ) continue;
                if(!visited[ny][nx]){
                    if (road[ny][nx] == 1) {
                        bfsmap[ny][nx] = bfsmap[nowR][nowC] +1;
                        visited[ny][nx] = true;
                        q.add(new Now(ny,nx));
                    }
                }
            }
        }
    }

    static class Now{
        int r;
        int c;
        Now(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
