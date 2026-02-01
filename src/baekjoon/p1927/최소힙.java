package baekjoon.p1927;

import java.io.*;
import java.util.*;
public class 최소힙 {

    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 가장 작은 값 출력 -> 힙 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 연산 N번 만큼
        for(int i = 0; i < N ; i++){
            int cal = Integer.parseInt(br.readLine());
            if(cal == 0){
                // pq가 비어있으면 0 출력 아니면 최솟값출력,제거
                int now = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(now);
            }
            else pq.add(cal);
        }

    }
}
