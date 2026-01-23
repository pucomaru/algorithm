package baekjoon.p1939;

import java.io.*;
import java.util.*;

// 다익스트라로 풀었는데 접근 잘못된거같음 근데 gpt가 다익스트라 + min/max 기법 쓰면 된다는데 min/max를 어디서 적용하라는지 모르겠음
public class 중량제한_틀린풀이 {

    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static List<Node>[] road;

    static int[] dist ;
    static boolean[] visited;
    static int start,end;

    // 문제 요구사항
    // 1. 섬(공장) -> 섬(공장) 최대로 옮길 수 있는 중량 값 구하기
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N (2 ~ 10,000) 개의 섬
        N = Integer.parseInt(st.nextToken());
        // M : 다리 정보 ( 중량 제한 정보 들어있음 )
        M = Integer.parseInt(st.nextToken());

        road = new ArrayList[N+1];

        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i = 0 ; i < N + 1 ; i++){
            road[i] = new ArrayList<>();
        }

        // 모든 다리는 양방향
        for (int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[a].add(new Node(b,c));
            road[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start,end);
    }



    static void dijkstra(int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue();

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(visited[now.idx]) continue;
            visited[now.idx] = true ;

            for (Node next : road[now.idx]){
                if (next.cost > dist[now.idx] && dist[next.idx] < dist[now.idx] + next.cost){
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.add(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        System.out.println(dist[end]);
    }



    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return Integer.compare(n.cost, this.cost);
        }
    }
}
