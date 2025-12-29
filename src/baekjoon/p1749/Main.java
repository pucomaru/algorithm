package baekjoon.p1749;

// 백준 1749 점수 따먹기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

    static int N, M;
    static int[][] matrix;
    static BufferedReader br;
    static StringTokenizer st;
    static int maxSum = 0;
    static void dfs(int r, int c , int[] row, int[] col){

        if (r >= N){
            int sum = 0;
            for(int i=0 ; i < row.length; i++){
                for (int j=0; j < col.length; j++){
                    sum += matrix[row[i]][col[j]];
                }
            }
            if (sum > maxSum){
                maxSum = sum;
            }

        } else{
            for
        }



    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 행
        N = Integer.parseInt(st.nextToken());
        // 열
        M = Integer.parseInt(st.nextToken());

        // 행렬
        matrix = new int[N][M];

        // 2차원 배열에 숫자들 넣기
        for(int i=0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M ; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] row = new int[N];
        int[] col = new int[M];

        dfs(0,0,row,col);

        System.out.println(maxSum);
    }
}
