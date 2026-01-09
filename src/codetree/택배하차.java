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

    // 택배 현재 위치 저장 (truck 돌면서 택배 어디있는지 찾기 복잡하니 따로 변수 선언)
    static int[][] location;

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
        location = new int[101][4];

        getOfforder = new ArrayList<>();

        // 택배 넣기
        for (int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 각각 택배 정보 (k= 택배 번호, h= 세로 , w = 가로, c= 좌측 좌표
            k = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken()) - 1;

            // 직사각형 현재 위치를 담을 배열 [행시작, 행끝, 열시작, 열끝]
            int[] R = {0,h-1,c,c + w - 1};
            R = gravityIn(R[0],R[1],R[2],R[3],k);
            location[k] = R;

        }

        // 택배 빼기
        while (getOfforder.size()<M){
            for (int i = 1 ; i <= M ; i++){
                // getOfforder 에 숫자 들어가있으면 이미 하차한 거
                if (getOfforder.contains(i)) continue;

                // 택배를 뺄 때는 행 좌우를 보는게 중요함
                int rowStart = location[i][0];
                int rowEnd = location[i][1];
                int colStart = location[i][2];
                int colEnd = location[i][3];


                // 왼쪽 빼기
                boolean left = true;
                for (int r = rowStart; r <= rowEnd && left; r++) {
                    for (int c = 0; c < colStart; c++ ){
                        if (truck[r][c] > 0){
                            left = false;
                            break;
                        }
                    }
                }

                // 오른쪽 빼기
                boolean right = true;
                if (!left){
                    for (int r = rowStart; r <= rowEnd && right; r++) {
                        for (int c = colEnd+1; c < N; c++ ){
                            if (truck[r][c] > 0){
                                right = false;
                                break;
                            }
                        }
                    }
                }

                if (left || right){
                    // 하차에 추가하기
                    getOfforder.add(i);
                    for (int r = rowStart ; r <= rowEnd ; r++){
                        for (int c = colStart ; c <= colEnd ; c++) {
                           truck[r][c] = 0;
                        }
                    }
                    gravityOut(colStart,colEnd,rowStart);
                }


            }
        }

        // 결과값
        for (int x : getOfforder) System.out.println(x);
    }

    // 택배 총 과정
    // 1. 택배 총 배치
    // 2. 택배 중력 떨어짐
    // 1 + 2 반복 후
    // 3. 택배 빼기
    // 4. 중력 떨어짐

    // 택배 떨어짐 (택배 넣었을떄)
    static int[] gravityIn(int rStart, int rEnd, int colStart,int colEnd, int rank){

        int rowlength = rEnd - rStart;

        // 최대로 떨어질 수 있는 행 저장
        int drop = rEnd;

        for (int i = rStart; i < N; i++){
            boolean canDrop = true ;
            // 떨어질때는 그 해당 열에 택배가 있는지만 확인
            for (int j = colStart; j <= colEnd; j++){
               if (truck[i][j]>0){
                   canDrop = false;
                   break;
               }
           }
           if (canDrop) drop = i;
           else break;
        }

        // 떨어진거 반영
        for (int i = drop - rowlength; i <= drop ; i++ )
            for (int j = colStart; j <= colEnd ;j++ ){
                truck[i][j] = rank;
            }

        int[] now = {drop-rowlength,drop,colStart,colEnd};
        return now;
    }

    // 택배 떨어짐 (택배 뻈을때)
    // 택배 뺄 때는 이제 위에 있느 택배들을 확인해야함
    static void gravityOut(int cStart, int cEnd, int rowStart) {
        for (int i = cStart; i <= cEnd; i++) {
            for (int j = 0; j < rowStart; j++) {
                if (truck[j][i] > 0) {
                    int nowGravity = truck[j][i];
                    int rS = location[nowGravity][0];
                    int rE = location[nowGravity][1];
                    int cS = location[nowGravity][2];
                    int cE = location[nowGravity][3];

                    // 지금 떨어지는 택배는 사라지는 택배니깐 0처리
                    for (int r = rS; r <= rE; r++) {
                        for (int c = cS; c <= cE; c++) {
                            truck[r][c] = 0;
                        }
                    }

                    location[nowGravity] = gravityIn(rS, rE, cS, cE, nowGravity);
                }
            }
        }
    }


}