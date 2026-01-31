package baekjoon.p10773;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class 제로 {
    static BufferedReader br;
    static StringBuilder sb;
    static int K ;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        int result = 0;
        for (int i =0 ; i < K ;i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0) q.pop();

            else q.push(now);
        }
        while(!q.isEmpty()){
            result += q.pop();
        }
        System.out.println(result);
    }
}
