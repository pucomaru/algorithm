package programmers;


class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int row = 0;
        int col = 0;
        // i = 0 금지
        // 0으로 나누면 런타임에러
        for(int i = 1 ; i <= Math.sqrt(total); i++){
            if (total % i == 0){
                int h = i ;
                int w = total / i;

                if (((h-2) * (w-2)) == yellow){
                    row =w;
                    col =h;
                }
            }
        }

        int[] answer = {row,col};
        return answer;


    }
}