package baekjoon.p1647;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


// 생각 정리
// Kruskal 이용
// 1. 일단 간선을 오름차 정렬
// 2. MST이 완성 되면 ... MST이 됐다는건 간선이 (N-1)개가 됐다는거
// 3. 2개의 마을을 만들라면 제일 가중치가 큰 간선하나를 없애는거
public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    // N = 집의 개수 / M = 길의 개수
    static int N, M ;
    // 길 유지비를 저장한 2차원 배열
    static int[][] road;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[N+1][N+1];

        // 길 유지비 정보 저장
        for (int i=0; i < M ; i++){
            st= new StringTokenizer(br.readLine());
            int home1 = Integer.parseInt(st.nextToken());
            int home2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            road[home1][home2] = cost;
            road[home2][home1] = cost;
        }


    }
}
