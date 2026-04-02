package programmers;


import java.util.HashSet;
import java.util.Set;

class Solution {

    static int[] parents;

    public int solution(int n, int[][] computers) {

        parents = new int[computers.length];

        // 부모 배열 초기화
        for (int i = 0; i < computers.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {

            int[] computer = computers[i];

            for(int j = 0 ; j < computer.length; j++){
                if( i == j || computer[j] == 0 ) continue;
                if(computer[j] == 1) {
                    union(i,j);
                }
            }
        }

//        Set<Integer> result = new HashSet<>();
//        for(int parent : parents ){
//            result.add(parent);
//        }

        // 결과는 find로만 !~~
        Set<Integer> result = new HashSet<>();
        for(int i = 0 ; i < computers.length ; i++ ){
            result.add(find(i));
        }


        return result.size();
    }

    static int find(int node) {

        if (parents[node] == node) return node;
        else {
            return parents[node] = find(parents[node]);
        }
    }

    static void union(int node, int node2) {
        node = find(node);
        node2 = find(node2);
        if (node != node2) {
            if (node < node2) {
                parents[node2] = node;
            } else {
                parents[node] = node2;
            }
        }
    }

}