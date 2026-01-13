package baekjoon.p15681;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class 트리와쿼리 {

    static BufferedReader br;
    static StringTokenizer st;

    // N : 트리의 정점의 수 / R : 루트의 번호 / Q : 쿼리의 수
    static int N, R, Q;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 트리의 정점의 수
        N = Integer.parseInt(st.nextToken());
        // 루트 번호
        R = Integer.parseInt(st.nextToken());
        // 쿼리의 수
        Q = Integer.parseInt(st.nextToken());

        // 간선 정보
        int[][] edge = new int[N-1][2];

        // 부모 정점
        int[] parent = new int[N+1];

        for(int i = 1; i < N+1 ; i++){
            parent[i] = i;
        }

        // 간선 정보 저장
        for (int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 ; j++){
                edge[i][j] = Integer.parseInt(st. nextToken()) ;
            }

        }
    }

    //
    static void union(){

    }

    // 부모 정점 찾는 함수
    static int find(int[] parent){

        return
    }
}
