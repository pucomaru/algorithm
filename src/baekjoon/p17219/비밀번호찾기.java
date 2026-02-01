package baekjoon.p17219;

import java.io.*;
import java.util.*;

public class 비밀번호찾기 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N,M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // N : 저장된 사이트 주소의 수
        N = Integer.parseInt(st.nextToken());
        // M : 비밀번호를 찾으려는 사이트 주소의 수
        M = Integer.parseInt(st.nextToken());

        HashMap<String,String> memo = new HashMap<>();
        // N번만큼 사이트 주소 저장
        for(int i = 0; i < N ; i++){
            // 공백을 기준으로 사이트 주소 , 비밀번호 저장
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String pw = st.nextToken();
            memo.put(address,pw);
        }
        // M번만큼 비밀번호 찾기
        for(int i = 0; i < M; i++){
            String address = br.readLine();
            String pw = memo.get(address);
            System.out.println(pw);
        }
    }
}
