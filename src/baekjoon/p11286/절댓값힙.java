package baekjoon.p11286;

import java.io.*;
import java.util.*;


public class 절댓값힙 {

    static BufferedReader br;
    static StringBuilder sb;

    static int N;

    // 힙
    // 가장 큰 값 or 가장 작은 값을 빨리 뽑아야 할 때 쓰는 자료구조
    // 최솟값/최댓값 조회 + 삭제

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // 힙형태
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{

            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA != absB) return absA - absB;
            return a - b;
        });

        for (int i = 0 ; i < N ; i ++){
           int num = Integer.parseInt(br.readLine());

           if (num != 0) pq.add(num);
           else {
               if(pq.isEmpty()) sb.append(0).append("\n");
               else {
                   int nowNum = pq.poll();
                   sb.append(nowNum).append("\n");
               }

           }
        }
        System.out.println(sb);

    }
}
