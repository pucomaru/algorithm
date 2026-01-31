package baekjoon.p4949;

import java.io.*;
import java.util.*;

public class 균형잡힌세상 {

    static BufferedReader br;
    static InputStreamReader st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            String sentence = br.readLine();
            Deque<Character> st = new ArrayDeque<>();
            if (sentence.equals(".")) {
                break;
            }
            boolean result = true;
            for(int i = 0; i < sentence.length(); i++) {
                char now = sentence.charAt(i);

                if (now == '(' || now == '[') st.push(now);
                else if (now == ')') {
                    if (st.isEmpty() || st.pop() != '(') {
                        result = false;
                        break;
                    }
                } else if (now ==']') {
                    if (st.isEmpty() || st.pop() != '[') {
                        result = false;
                        break;
                    }
                }

            }
            if (!st.isEmpty()) result = false;
            if (result) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}