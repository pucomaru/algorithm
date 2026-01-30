package baekjoon.p2667;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    static BufferedReader br;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> town;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        // 지도의 크기 N
        N = Integer.parseInt(br.readLine());
        // 지도
        map = new int[N][N];
        // 단지수
        town = new ArrayList<>();
        // 방문 배열
        visited = new boolean[N][N];

        // 지도 정보 대입
        for(int i = 0 ; i < N; i++){
            String info = br.readLine();
            for(int j = 0; j < N ; j++){
                // charAt으로 받으면 문자로 나오니까 '0'을 뺴서 숫자로인식
                map[i][j] = info.charAt(j) - '0';
            }
        }

        // 돌면서 단지 시작점 찾기
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++){
            if (map[i][j] == 1 && !visited[i][j]) {
                int townRange = bfs(i, j);
                town.add(townRange);
                }
            }
        }

        // 리스트 정렬
        Collections.sort(town);

        // 단지 수
        System.out.println(town.size());
        // 단지 오름차순 print
        for(int i = 0 ; i < town.size(); i++){
            System.out.println(town.get(i));
        }

    }

    static int bfs(int nowY, int nowX) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{nowY, nowX});
        visited[nowY][nowX] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            nowY = now[0];
            nowX = now[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(visited[ny][nx]) continue;
                if (map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    }
                }
            }
        return count;
    }



}
