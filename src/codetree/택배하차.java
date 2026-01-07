import java.util.*;
import java.io.*;

public class 택배하차 {

    static BufferedReader br;
    static StringTokenizer st;

    // 택배 트럭 크기(정사각형)
    static int N;

    // 택배 위치 정보 택배 갯수
    static int M;

    // 택배 저장 칸
    static int[][] truck;

    // 택배 위치 저장
    static int[] location;

    // k = 택배 번호 / h = 세로 길이 // w = 가로 길이 // c = 왼쪽 열 위치
    static int k,h,w,c;

    // 택배 뺀 순서 (순서는 누가 먼저 들어갈지 모르기에 배열말고 리스트로 선언 )
    static List<Integer> getOfforder ;

    public static void main() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        truck = new int[N][N];
        getOfforder = new ArrayList<>();
        location = new int[M+1];

        // 택배 넣기
        for (int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 각각 택배 정보 (k= 택배 번호, h= 세로 , w = 가로, c= 좌측 좌표
            k = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 직사각형 현재 위치를 담을 배열 [행시작, 행끝, 열시작, 열끝]
            int[] R = new int[4] ;

            R = gravity(h,w,c);

            for (int r = R[0] ; r < R[1] ; r++){
                for (int c = R[2] ; r < R[3] ; c ++){
                    truck[r][c] = k;
                }
            }

        }

        // 택배 빼기
        while (getOfforder.size()<M){

            for (int i = 1 ; i <= M ; i++){
                (if getOfforder.contains(i) ==){
                    gravity();
                }
            }
        }

        for(int i=0;i < M ;i++){
            System.out.println(getOfforder.indexOf(i));
        }

    }


    // 택배 총 과정
    // 1. 택배 총 배치
    // 2. 택배 중력 떨어짐
    // 1 + 2 반복 후
    // 3. 택배 빼기
    // 4. 중력 떨어짐

    // 탭개 떨어짐
    static int[] gravity(int w, int h, int c){

        int rowRange = 0;
        int columnRange = 0;
        int[] rectangleRange = new int[4];


        return rectangleRange;
    }

    // 택배 빼기

}