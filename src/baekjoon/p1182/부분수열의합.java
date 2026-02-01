package baekjoon.p1182;

import java.io.*;
import java.util.*;

public class 부분수열의합 {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, S;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N : 정수의 개수
        N = Integer.parseInt(st.nextToken());
        // 다 더한 값
        S = Integer.parseInt(st.nextToken());
        // 수열
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        dfs(0,0);
        if(S == 0) result --;
        System.out.println(result);

    }

    static void dfs(int now,int sum){
        if (now == N) {
            if(sum == S) result++;
            return;
        }

        // 지금 포함
        sum += arr[now];
        dfs(now+1,sum);
        // 지금 미포함
        sum -= arr[now];
        dfs(now+1,sum);
    }
}
