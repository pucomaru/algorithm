package programmers;

import java.io.*;
import java.util.*;

class Solution {

    static PriorityQueue<Integer> pq ;
    static int k ;
    public int solution(int[] scoville, int K) {

        k = K;

        pq = new PriorityQueue<>();

        for(int s : scoville){
            pq.offer(s);
        }

        int mixCount = 0;

        while(!pq.isEmpty() && pq.peek() < k){
            if(pq.size() <= 1){
                return -1;
            }
            int firstNum = pq.poll();
            int secondNum = pq.poll();

            int mix = firstNum + secondNum* 2;
            pq.offer(mix);
            mixCount++;
        }

        return mixCount;
    }

}
