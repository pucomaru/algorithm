package baekjoon.p14889;

import java.io.*;
import java.util.*;
public class 스타트와링크 {
    static final int MAX_NUN = Integer.MAX_VALUE;
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] ability;
    static List<Integer> startTeam;
    static List<Integer> linkTeam;
    static int result;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // N : 축구하려고 모인 사람 수 ( 1 ~ N )
        N = Integer.parseInt(br.readLine());
        // 능력치 배열
        ability = new int[N+1][N+1];
        // 능력치 정보 저장
        for(int i = 1 ; i < N + 1 ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1  ;j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startTeam = new ArrayList<>();
        linkTeam = new ArrayList<>();

        result = MAX_NUN;
        comb(1,0);
        System.out.println(result);
    }

    static void comb(int start, int depth){
        if (depth == N/2){
            // 리스트라 꼭 초기화해줘야함 아니면 누적될수도있음
            linkTeam.clear();
            for(int i = 1 ; i < N+1; i++){
                if(!startTeam.contains(i)) linkTeam.add(i);
            }
            cal();
            return;
        }
        for(int i = start; i < N + 1; i++){
            startTeam.add(i);
            comb(i+1,depth+1);
            // 백트래킹 필수 리스트라 계속 누적될수도
            startTeam.remove(startTeam.size()-1);
        }

    }

    static void cal(){
        int startTotal = 0;
        int linkTotal = 0;

        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2 ; j++){
                if(i == j) continue;
                int one = startTeam.get(i);
                int two = startTeam.get(j);
                startTotal += ability[one][two];
            }
        }

        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2 ; j++){
                if(i == j) continue;
                int one = linkTeam.get(i);
                int two = linkTeam.get(j);
                linkTotal += ability[one][two];
            }
        }

        int cal = Math.abs(linkTotal-startTotal);

        if(result > cal) result = cal;

    }
}
