package programmers;

class 타겟넘버 {
    static int numberLength;
    static int t;
    static int answer;
    static int[] num;

    public int solution(int[] numbers, int target) {

        num = numbers;
        numberLength = num.length;
        answer = 0;
        t = target;

        dfs(0,0);

        return answer;
    }

    static void dfs(int now, int sum){
        if(now >= numberLength){
            if(sum == t){
                answer++;
            }
            return;
        }

        int nowNum = num[now];
        dfs(now+1,sum+nowNum);
        dfs(now+1,sum-nowNum);
    }
}