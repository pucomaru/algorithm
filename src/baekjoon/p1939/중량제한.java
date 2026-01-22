package baekjoon.p1939;

import java.io.*;
import java.util.*;


public class 중량제한{

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] visited;
    static int[] dist;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 섬의 개수
        N = Integer.parseInt(st.nextToken());
        // 다리 정보 ( 간선 정보 )
        M = Integer.parseInt(st.nextToken());
        // 방문 배열
        visited = new int[N+1];
        // 거리 배열
        dist = new int[N+1];
        // 간선 정보 인접 리스트
        graph = new ArrayList[N+1];
        // 리스트 섬 개수 만큼 선언
        for (int i = 0 ; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 graph에 저장
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // c = 중량 제한의 값
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());


    }

    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        // 생성자
        Node(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost , n.cost);
        }
    }
}
