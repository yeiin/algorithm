import java.util.*;

class Solution {

    // 소문자별 등장 위치
    private final Map<Character, List<Integer>> map = new HashMap<>();
    private final Set<Character> used = new HashSet<>();
    private static final String INVALID = "invalid";

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    // 대문자 사이에 같은 소문자가 들어간 형태 검증 및 복원
    // 예: AbBbC → ABC
    public String rules2(String s) {
        if (s.isEmpty() || s.length() % 2 == 0) {
            return INVALID;
        }

        if (s.length() == 1) {
            return isUpper(s.charAt(0)) ? s : INVALID;
        }

        char marker = s.charAt(1);

        if (!isLower(marker) || used.contains(marker)) {
            return INVALID;
        }

        // 이 소문자가 현재 단어 밖에서도 사용되면 안 됨
        List<Integer> positions = map.get(marker);
        if (positions == null
                || positions.size() != s.length() / 2) {
            return INVALID;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i % 2 == 0) {
                if (!isUpper(c)) return INVALID;
                result.append(c);
            } else {
                if (c != marker) return INVALID;
            }
        }

        used.add(marker);
        return result.toString();
    }

    public String solution(String sentence) {
        // 같은 객체에서 다시 호출되어도 이전 기록이 남지 않도록 초기화
        map.clear();
        used.clear();

        if (sentence.isEmpty()) return INVALID;

        char[] arr = sentence.toCharArray();
        List<String> words = new ArrayList<>();

        // 소문자만 저장하고, 영문자가 아닌 문자는 거절
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (isLower(c)) {
                map.computeIfAbsent(c, key -> new ArrayList<>()).add(i);
            } else if (!isUpper(c)) {
                return INVALID;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            String word;

            if (isLower(arr[i])) {
                // 소문자로 감싸진 단어
                char marker = arr[i];
                List<Integer> positions = map.get(marker);

                if (used.contains(marker)
                        || positions.size() != 2
                        || positions.get(0) != i) {
                    return INVALID;
                }

                int end = positions.get(1);

                // 내부가 비어 있으면 안 됨
                if (end <= i + 1) return INVALID;

                used.add(marker);

                String inner = sentence.substring(i + 1, end);

                // 일부 문자만 보지 않고 내부 전체를 검사
                boolean allUpper = true;
                for (int j = 0; j < inner.length(); j++) {
                    if (!isUpper(inner.charAt(j))) {
                        allUpper = false;
                        break;
                    }
                }

                if (allUpper) {
                    word = inner;
                } else {
                    word = rules2(inner);
                    if (INVALID.equals(word)) return INVALID;
                }

                i = end;

            } else {
                if (i == arr.length - 1 || isUpper(arr[i + 1])) {
                    // 현재 대문자를 한 단어로 처리
                    word = String.valueOf(arr[i]);

                } else {
                    char marker = arr[i + 1];
                    List<Integer> positions = map.get(marker);

                    if (used.contains(marker)
                            || positions.get(0) != i + 1) {
                        return INVALID;
                    }

                    if (positions.size() == 2) {
                        // 현재 대문자는 단독 단어로 처리
                        // 다음 반복에서 소문자로 감싸진 부분을 처리
                        word = String.valueOf(arr[i]);

                    } else {
                        // 마지막 소문자 다음에 대문자가 있어야 함
                        int end = positions.get(positions.size() - 1) + 1;

                        if (end >= arr.length) return INVALID;

                        word = rules2(sentence.substring(i, end + 1));
                        if (INVALID.equals(word)) return INVALID;

                        i = end;
                    }
                }
            }

            words.add(word);
        }

        return String.join(" ", words);
    }
}