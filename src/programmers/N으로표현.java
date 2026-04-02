package programmers;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {


    public int solution(int N, int number) {

        // Set 배열 선언
        Set<Integer>[] dp = new HashSet[9];

        // 선언안하면 null 이라 오류남
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        for (int k = 1; k < 9; k++) {

            int concat = 0;
            for (int i = 0; i < k; i++) {
                concat = (concat * 10) + N;
            }
            dp[k].add(concat);

            for (int i = 1; i < k; i++) {
                for (int a : dp[i]) {
                    for (int b : dp[k - i]) {
                        dp[k].add(a + b);
                        dp[k].add(a - b);
                        dp[k].add(a * b);
                        if (b != 0) {
                            dp[k].add(a / b);
                        }
                    }
                }
            }

            if (dp[k].contains(number)) return k;

        }
        return -1;
    }

}