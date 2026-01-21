package baekjoon.p1956;

import java.io.*;
import java.util.*;

public class 운동 {

    static BufferedReader br;
    static StringTokenizer st;
    static int V, E;
    static int[][] road;
    static int result;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // V개의 마을 ( 1번 부터 V번까지의 마을 )
        V = Integer.parseInt(st.nextToken());
        // E개의 도로 (일반 통행 도로 / 양방향 X)
        E = Integer.parseInt(st.nextToken());
        // 간선 정보 저장
        road = new int[V+1][V+1];

        for(int i = 0 ; i < E ; i ++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a][b] = c;
        }

        result = Integer.MAX_VALUE ;
        // 문제 요구사항
        // => 도로의 길이의 합이 최소가 되는 사이클 찾기
        // => 두 마을을 왕복하는 경우도 사이클에 포함 ( ex ) 1 - 2 는 가능하다는 뜻  )
        for (int i = 1; i < V + 1 ; i++){
            int[] visited = new int[V+1];
            dfs(i,i,0,visited);
        }

        if (result == Integer.MAX_VALUE){
            System.out.println(-1);
        } else System.out.println(result);

    }

    static void dfs(int start, int now,int sum, int[] visited){
        if (sum > result) return;

        if (sum != 0 && start == now){
            if (sum < result) {
                result = sum;
                return;
            }
        }

        for(int i = 1 ; i < V + 1; i ++){
            if (road[now][i] > 0 && visited[i] == 0){
                visited[i] = 1;
                dfs(start, i , sum + road[now][i], visited);
                visited[i] = 0;
            }
        }
    }

}
