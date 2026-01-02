package baekjoon.p2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

// 품
// 큐 방식은 맨 앞 원소를 제거하거나 뒤에 추가할 떄 실제로 모든 원소를 이동시키지 않고,
// 맨 앞과 맨 뒤를 가리키는 위치만 변경한다. poll(),add() 는 카드들을 한 칸씩 밀어내는
// 작업이 아니라 인덱스(포인터)만 이동하는 연선이어서 한 번에 처리되는 비용이 매우 작다.

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드들
        Queue<Integer> cardList = new ArrayDeque<>();

        // 카드 갯수
        int numberOfCards = Integer.parseInt(br.readLine());

        // 카드에 1 ~ N 넣기
        for (int i = 0; i < numberOfCards; i++){
            cardList.add(i+1);
        }

        // 카드 맨앞 카드 제거후 다음 카드 뒤로 옮기기 반복 작업
        while (cardList.size() > 1){
            cardList.poll();
            cardList.add(cardList.poll());
        }

        System.out.println(cardList.peek());

    }
}
