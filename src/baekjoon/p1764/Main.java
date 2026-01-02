package baekjoon.p1764;

// 백준 1764번 듣보잡

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

// Hashset, 리스트/배열 차이.. util 등을 알게됨
public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        // 듣도 못한 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 보도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람
        HashSet<String> noHeard = new HashSet<>();

        // 듣도 못한 사람
        for (int i = 0; i < N; i++) {
            noHeard.add(br.readLine());
        }

        // 듣보잡 저장용 리스트 (정렬을 위해)
        // 듣보잡이 몇명일지 모르니 가변의 속성을 가진 리스트 이용
        ArrayList<String> result = new ArrayList<>();

        // 보도 못한 사람
        for (int i = 0; i < M; i++) {
            String person = br.readLine();

            if (noHeard.contains(person)) {
                result.add(person);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String name : result){
            System.out.println(name);
        }
    }
}
