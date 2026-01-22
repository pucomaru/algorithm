package baekjoon.p1956;

import java.io.*;
import java.util.*;

public class 다익스트라{

    static BufferedReader br;
    static StringTokenizer st;
    static int n,m;

    // 인접 리스트 형태 : 배열 안에 리스트
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
       br = new BufferedReader(new InputStreamReader(System.in));
       st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       // 노드의 수만큼 선언
       graph = new ArrayList[n+1];

       // 배열 내부에 리스트 선언
       for (int i = 0 ; i < n+1 ; i++){
           graph[i] = new ArrayList<>();
       }

       // 간선 정보 (노드 형태) 추가
       for (int i = 0; i < m ; i++){
           st = new StringTokenizer(br.readLine());

           int a = Integer.parseInt(st.nextToken());
           int b= Integer.parseInt(st.nextToken());
           int cost = Integer.parseInt(st.nextToken());

           graph[a].add(new Node(b,cost));
       }

       // start 는 시작점
       int start = Integer.parseInt(br.readLine());

       // 다익스트라 실행
        dijkstra(n, start);
    }

    static void dijkstra(int n, int start){

        boolean[] visited = new boolean[n+1];

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 출발지 -> 출발지는 거리값이 0
        distance[start] = 0;

        // 우선순위 큐 선언
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 출발지 Q에 넣기
        pq.offer(new Node(start,0));

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.idx]) continue;
            visited[now.idx] = true;

            for (Node next : graph[now.idx]){

                // 현재 다음 노드의 저장돼있는 거리 값과 (지금까지 노드의 거리값 + 다음노드와 현재노드의 간선길이) 비교해서 작은 값 갱신
                if (distance[next.idx] > next.cost + distance[now.idx]){
                    distance[next.idx] =  next.cost + distance[now.idx];
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
//        System.out.println(distance[도착점]);

    }

    // 노드 Class 선언
    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        // 생성자
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }
}
