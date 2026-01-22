package baekjoon.p1753;


import java.io.*;
import java.util.*;

public class 최단경로 {

    static BufferedReader br;
    static StringTokenizer st;
    static int V, E;
    static boolean[] visited;
    static int[] dist;
    static List<Node>[] graph;
    static int start ;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 정점의 개수
        V = Integer.parseInt(st.nextToken());
        // 다리 정보 ( 간선 정보 )
        E = Integer.parseInt(st.nextToken());
        // 방문 배열
        visited = new boolean[V + 1];
        // 거리 배열
        dist = new int[V + 1];
        // 간선 정보 인접 리스트
        graph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist,Integer.MAX_VALUE);

        start = Integer.parseInt(br.readLine());
        // 간선 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(start);
    }

    static void dijkstra(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            if (visited[nowNode.idx]) continue;
            visited[nowNode.idx] = true;

            for (Node next : graph[nowNode.idx]){
                if (dist[next.idx] > dist[nowNode.idx] + next.cost){
                    dist[next.idx] = dist[nowNode.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for (int i = 1; i < V+1 ; i++){
            if ( dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }
}
