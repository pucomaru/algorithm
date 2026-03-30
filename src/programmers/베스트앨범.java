import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생수
        Map<String, Integer> genreTotal = new HashMap<>();

        // 장르별 노래 리스트 - Song클래스 대신 int[]로 [재생수, 인덱스]
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        // 데이터 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 1. 총 재생수 - getOrDefault로 null 체크 제거
            int currentTotal = genreTotal.getOrDefault(genre, 0);
            genreTotal.put(genre, currentTotal + play);

            // 2. 리스트 없으면 생성
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }

            // 3. 노래 추가 - [재생수, 고유번호] 형태로
            genreSongs.get(genre).add(new int[]{play, i});
        }

        // 장르 리스트로 변환
        List<String> genreList = new ArrayList<>(genreTotal.keySet());

        // 총 재생수 기준 내림차순 정렬
        Collections.sort(genreList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return genreTotal.get(b) - genreTotal.get(a);
            }
        });

        // 결과 저장
        List<Integer> result = new ArrayList<>();

        for (String genre : genreList) {
            List<int[]> songs = genreSongs.get(genre);

            // 노래 정렬 - 재생수 내림차순, 같으면 고유번호 오름차순
            Collections.sort(songs, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1]; // 고유번호 오름차순
                    }
                    return b[0] - a[0]; // 재생수 내림차순
                }
            });

            // 최대 2곡 추가
            int count = 0;
            for (int[] song : songs) {
                result.add(song[1]); // 고유번호(인덱스) 추가
                count++;
                if (count == 2) break;
            }
        }

        // List → 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}