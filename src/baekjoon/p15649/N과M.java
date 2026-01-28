package baekjoon.p15649;

import java.io.*;
import java.util.*;
public class N과M {

    static BufferedReader br;
    static StringTokenizer st;

    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N+1];
        dfs(0);
    }

    static void dfs(int depth){

        if(depth == M) {
            for (int i = 0; i < M ; i++){
                if (i == M-1) System.out.println(arr[i]);
                else{
                    System.out.print(arr[i]);
                    System.out.print(" ");;
                }
            }
            return;
        }
        for (int i = 1; i < N+1; i++){
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    };
}
