package programmers;

import java.util.*;
import java.io.*;

class Solution {

    static StringBuilder sb;

    public String solution(int[] numbers) {

        // 정수로 비교하면 compare 짜는거 감이 안옴
        // 문자로 바꿔서 앞뒤 이은거 비교하는 아이디어

        String[] strings = new String[numbers.length];

        // 문자열로 변환
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        // ex. [6,10,2] -> ["6","10","2"]

        // Arrays.sort 는 모든 변수 쌍 비교해줌
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));

        sb = new StringBuilder();

        for (String s : strings) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}