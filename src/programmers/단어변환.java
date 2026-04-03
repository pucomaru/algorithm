package programmers;

import java.io.*;
import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {

        Queue<String> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(begin);
        int count = 0 ;

        while (!queue.isEmpty()){
            int size = queue.size();
            count++;

            for(int i =0 ; i < size ; i++){
                String cur = queue.poll();

                for(int j = 0 ; j < words.length;j++){
                    if(!visited[j] && sameCount(cur,words[j]) == 1){
                        if(words[j].equals(target)) return count;
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
        }

        return 0;
    }

    static int sameCount(String cur, String comp){
        int diff = 0 ;
        for(int i = 0; i < cur.length(); i++){
            if (diff >= 2) return 0;
            if(cur.charAt(i) != comp.charAt(i)) diff++;
        }
        if (diff >= 2) return 0;
        else return 1;
    }

}