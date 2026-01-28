package baekjoon.p9012;

import java.io.*;
import java.util.*;

public class 괄호 {

    static BufferedReader br;
    static StringTokenizer st;

    static int T;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++){
            String sentence = br.readLine();

            int openCount = 0;
            int closeCount = 0;
            for (int j = 0 ; j < sentence.length(); j++){
                if (sentence.charAt(j) == '('){
                    openCount++;
                }
                if (sentence.charAt(j) == ')'){
                    if(openCount<=0) closeCount ++;
                    else openCount--;
                    }
            }

            if (openCount > 0 || closeCount > 0) System.out.println("NO");
            else System.out.println("YES");

        }

    }
}
