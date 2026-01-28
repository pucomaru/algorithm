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
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        comb(0,M);
    }

    static void comb(int start, int depth){

        if(depth == M){
            System.out.println();
        }

        for (int i = start ; i < N + 1 ; i++ ){
            arr[depth] = i;

        }
    }
}
