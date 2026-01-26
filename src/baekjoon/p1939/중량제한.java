package baekjoon.p1939;

import java.io.*;
import java.util.*;

public class 중량제한 {

    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[][] road;

    static int start,end;

    static List<Integer> weight;

    static int result;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N (2 ~ 10,000) 개의 섬
        N = Integer.parseInt(st.nextToken());
        // M : 다리 정보 ( 중량 제한 정보 들어있음 )
        M = Integer.parseInt(st.nextToken());

        road = new int[N+1][N+1];
        weight = new ArrayList<>();

        // 다리 정보 추가 + 이어져 있는 애들 합치기
        for (int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a][b] = c;
            road[b][a] = c;
            weight.add(c);
        }

        // 오름차순 정렬
        Collections.sort(weight);
        int mid = weight.size() / 2 ;

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        result = bfs(start, end);

    }

    static int bfs(int start, int end){
        List<Integer>[] q = new List[];
    }
}
