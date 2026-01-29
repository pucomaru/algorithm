package baekjoon.p2667;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    static BufferedReader br;
    static int N;
    static int[][] map;
    static List<Home> town;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        // 지도의 크기 N
        N = Integer.parseInt(br.readLine());
        // 지도
        map = new int[N][N];
        // 단지수
        town = new ArrayList<>();

        // 지도 정보 대입
        for(int i = 0 ; i < N; i++){
            String info = br.readLine();
            for(int j = 0; j < N ; j++){
                map[i][j] = info.charAt(j);
            }
        }

        int result = 0 ;


    }

    static void bfs(int nowX, int nowY){

    }

    static class Home{
        int homeNum;
        int count;

        Home(int homeNum, int count){
            this.homeNum = homeNum;
            this.count = count;
        }
    }

}
