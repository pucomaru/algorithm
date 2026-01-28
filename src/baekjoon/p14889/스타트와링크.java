package baekjoon.p14889;

import java.io.*;
import java.util.*;

// 푸는중
public class 스타트와링크 {

    static final int MAX_VALUE = Integer.MAX_VALUE;
    static BufferedReader br;
    static StringTokenizer st;

    static int N ;
    static int[][] ability;

    static int[] teamA;
    static int[] teamB;

    static int result;

    // 안 겹치는 조합으로 몇팀까지 나오는지
    static int setTeam;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 ( 4 <= N <= 20 )
        N = Integer.parseInt(br.readLine());

        // 능력 판 ( N * N )
        ability = new int[N][N];

        // 능력 판 정보 저장
        for (int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        teamA = new int[N/2];
        teamB = new int[N/2];

        boolean[] already = new boolean[N+1];

        int result = MAX_VALUE;
        setTeam =
        team(0);
    }

    // 조합으로 뽑기
    static void team(int idx){
        for (int i = 0; )

    }

    // ability 계산 dfs
    static void ability(int[] teamA, int[] teamB){

        // 두팀 다 N/2 크기만큼 팀이 정해지면 이제 능력치 계산
        if (teamA.length == N/2 && teamB.length == N/2){
            int totalAbilityA = 0;
            int totalAbilityB = 0;



        }
    }
}
