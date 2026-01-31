package baekjoon.p10828;

import java.io.*;
import java.util.*;

public class 스택 {

    static BufferedReader br;
    static StringTokenizer st;

    static int N;

    static List<Integer> arr;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        // 명령어 수
        N = Integer.parseInt(br.readLine());
        // 스택
        arr = new ArrayList<>();

        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                arr.add(num);
            }

            if(order.equals("top")){
                int leng = arr.size();
                if (arr.isEmpty()) System.out.println(-1);
                else System.out.println(arr.get(leng -1));
            }

            if(order.equals("size")){
                int leng = arr.size();
                System.out.println(leng);
            }

            if(order.equals("pop")){
                if(arr.isEmpty()) System.out.println(-1);
                else {
                    int leng = arr.size();
                    int num = arr.get(leng-1);
                    System.out.println(num);
                    arr.remove(leng-1);
                }
            }

            if(order.equals("empty")){
                if(arr.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
}
