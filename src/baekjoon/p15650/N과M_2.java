package baekjoon.p15650;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

// 조합문제 푸는중
public class N과M_2 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N , M;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 1 ~ N 수
        N = Integer.parseInt(st.nextToken());
        // 길이 M
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        comb(1, 0);
    }

    static void comb(int start, int depth){

        if(depth == M){
            for (int i = 0 ; i < M ; i++){
                System.out.print(arr[i]);
                if (i != M-1 )System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = start ; i <= N ; i++ ){
            arr[depth] = i;
            comb(i + 1, depth + 1 );
        }
    }
}
