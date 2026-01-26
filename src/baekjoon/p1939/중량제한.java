package baekjoon.p1939;

import java.io.*;
import java.util.*;

// 이분 탐색 + bfs 이용
public class 중량제한 {

    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;

    // 이차원 배열로 선언하면 메모리 초과 확률 높으니 인접리스트로 선언
    static List<Edge>[] road;

    static int start,end;

    static int result;

    static int high;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N (2 ~ 10,000) 개의 섬
        N = Integer.parseInt(st.nextToken());
        // M : 다리 정보 ( 중량 제한 정보 들어있음 )
        M = Integer.parseInt(st.nextToken());

        road = new ArrayList[N+1];
        for (int i=0 ; i <N+1 ; i++){
            road[i] = new ArrayList<>();
        }

        high = 0;
        // 다리 정보 추가
        for (int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a].add(new Edge(b,c));
            road[b].add(new Edge(a,c));

            // 제일 높은 중량제한 저장
            if (c > high) high = c;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = 0;
        int low = 1 ;

        // 이분탐색
        while(low <= high){
            // mid = 중량 제한 설정
            int mid = ( high + low ) / 2;
            // mid로 성공을 하면 mid 위 범위부터 다시 세크
            if (canPass(mid)){
                answer = mid;
                low = mid + 1;
            } else {
                // 실패하면 mid 아래 범위
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }


    // bfs
    static boolean canPass(int mid){
        Queue<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()){
            int now = q.poll();
            // end 까지 도착하면 중량 초과안하고 잘 전달
            if (now == end) return true;
            for (Edge e : road[now]){
                if ((!visited[e.to])&& e.limit >= mid){
                    visited[e.to] = true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }

    static class Edge{
        int to;
        int limit;

        Edge(int to, int limit){
            this.to = to;
            this.limit = limit;
        }

    }
}
