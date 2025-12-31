package baekjoon.p1749;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// kadane 헷갈려서 다시 풀어봄
public class Main2 {
    static BufferedReader br;
    static StringTokenizer st;

    // N = 행 / M = 열
    static int N, M;
    static int[][] matrix;

    static int result = Integer.MIN_VALUE;
    static void kadane(int top){

        int[] colSum = new int[M];

        for (int bottom = top; bottom < N ; bottom++) {

            for (int col = 0 ; col < M ; col++){
                colSum[col] += matrix[bottom][col];
            }

            int now = colSum[0];
            int best = colSum[0];

            for (int col = 1 ; col <M ;col++){
                now = Math.max(colSum[col], colSum[col] + now);
                best = Math.max(now,best);
            }
            result = Math.max(best,result);
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N ; i ++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M ; j ++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int top = 0; top < N; top++){
            kadane(top);
        }
        System.out.println(result);
    }
}
