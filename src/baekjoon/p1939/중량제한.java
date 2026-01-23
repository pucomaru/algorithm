package baekjoon.p1939;

import java.io.*;
import java.util.*;

// 다익스트라로 풀었는데 접근 잘못된거같음 근데 gpt가 다익스트라 + min/max 기법 쓰면 된다는데 min/max를 어디서 적용하라는지 모르겠음
public class 중량제한 {

    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[][] road;

    static int start,end;

    static int[] parent;

    // 유니온 - 파인드
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N (2 ~ 10,000) 개의 섬
        N = Integer.parseInt(st.nextToken());
        // M : 다리 정보 ( 중량 제한 정보 들어있음 )
        M = Integer.parseInt(st.nextToken());

        road = new int[N+1][N+1];
        parent = new int[N+1];

        for (int i = 1 ; i < N + 1 ; i++){
            parent[i] = i;
        }

        // 다리 정보 추가 + 이어져 있는 애들 합치기
        for (int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a][b] = c;
            road[b][a] = c;
            union(a,b);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i=1 ; i < N +1 ; i ++){

            if (i != end){
                if (parent[i] == parent[end] && result < road[end][i]){
                    result = road[end][i];
                }
            }
        }
    }

    static void union(int x, int y){
        if (find(x) != find(y)){
            if ( x == start ) parent[y] = x;
            else if ( y == start) parent[x] = y;
            else (x < y) parent[y] = x;
        }

    }

    static int find(int x){
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }
}
