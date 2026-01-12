package baekjoon.p12865;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    // N : 물건
    static int N;
    // K : 가지고 다닐 수 있는 최대 무게
    static int K;
    // 가치
    static int[] value ;
    // 무게
    static int[] weight;
    // DP
    static int[][] dp ;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 가방의 수
        N = Integer.parseInt(st.nextToken());
        // 최대 무게
        K = Integer.parseInt(st.nextToken());

        value = new int[N + 1];
        weight = new int[N + 1];

        dp = new int[K + 1][N + 1];

        for (int i = 1; i < N+1 ; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weight[i] = w;
            value[i] = v;
        }

        DP();

        System.out.println(dp[K][N]);
    }

    static void DP() {
        // i는 무게 순 ( 가볍 -> 무겁)
        for (int i = 1; i < K + 1; i++) {
            // j는 아이템 순서
            for (int j = 1; j < N + 1 ; j++) {
                int nowWeight = weight[j];
                if (i - nowWeight >= 0) {
                    // 현재의 짐을 포함안했을떄의 값을 더해야 하므로 dp[i-nowWeight][j]가 아니라 dp[i-nowWeight][j-1]
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-nowWeight][j-1] + value[j]);
                }  else dp[i][j] = dp[i][j-1];

            }
        }
    }
}