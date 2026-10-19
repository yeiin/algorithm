import java.util.*;

class Solution {

    public String solution(String sentence) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        // 소문자 등장 횟수 기록
        for (char c : sentence.toCharArray()) {
            if (isLower(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        char[] arr = sentence.toCharArray();
        boolean[] used = new boolean[26];

        int idx = 0;
        StringBuilder temp = new StringBuilder();

        while (idx < arr.length) {
            char c = arr[idx];

            // 1. 대문자로 시작하는 경우
            if (isUpper(c)) {

                // 규칙 1: 대문자 사이에 동일한 소문자가 반복
                if (idx + 1 < arr.length
                        && isLower(arr[idx + 1])
                        && map.get(arr[idx + 1]) != 2) {

                    char mark = arr[idx + 1];

                    if (used[mark - 'a']) {
                        return "invalid";
                    }

                    if (temp.length() > 0) {
                        list.add(temp.toString());
                        temp.setLength(0);
                    }

                    StringBuilder word = new StringBuilder();
                    word.append(c);

                    int count = map.get(mark);
                    idx++;

                    for (int i = 0; i < count; i++) {

                        if (idx >= arr.length || arr[idx] != mark) {
                            return "invalid";
                        }

                        idx++;

                        if (idx >= arr.length || !isUpper(arr[idx])) {
                            return "invalid";
                        }

                        word.append(arr[idx]);
                        idx++;
                    }

                    used[mark - 'a'] = true;
                    list.add(word.toString());

                } else {
                    // 규칙이 적용되지 않은 일반 대문자
                    temp.append(c);
                    idx++;
                }

            } else {
                // 2. 소문자로 시작하는 경우: 규칙 2
                if (map.get(c) != 2 || used[c - 'a']) {
                    return "invalid";
                }

                int start = idx;
                int end = sentence.indexOf(c, start + 1);

                // 닫는 소문자가 없거나 내부에 문자가 없는 경우
                if (end <= start + 1) {
                    return "invalid";
                }

                if (!isUpper(arr[start + 1])) {
                    return "invalid";
                }

                StringBuilder word = new StringBuilder();
                boolean hasInnerLower = false;

                // 규칙 2 내부에 규칙 1이 존재하는지 확인
                for (int i = start + 1; i < end; i++) {
                    if (isLower(arr[i])) {
                        hasInnerLower = true;
                        break;
                    }
                }

                // 2-1. 규칙 1과 규칙 2가 중첩된 경우
                if (hasInnerLower) {

                    int length = end - start - 1;

                    // 대문자 소문자 대문자 ... 대문자 형태
                    if (length < 3 || length % 2 == 0) {
                        return "invalid";
                    }

                    char inner = arr[start + 2];

                    if (!isLower(inner)
                            || inner == c
                            || used[inner - 'a']) {
                        return "invalid";
                    }

                    if (map.get(inner) != length / 2) {
                        return "invalid";
                    }

                    for (int i = start + 1; i < end; i++) {

                        if ((i - start - 1) % 2 == 0) {
                            // 대문자 위치
                            if (!isUpper(arr[i])) {
                                return "invalid";
                            }

                            word.append(arr[i]);

                        } else {
                            // 동일한 소문자인지 확인
                            if (arr[i] != inner) {
                                return "invalid";
                            }
                        }
                    }

                    used[inner - 'a'] = true;

                } else {
                    // 2-2. 규칙 2만 적용된 경우
                    for (int i = start + 1; i < end; i++) {

                        if (!isUpper(arr[i])) {
                            return "invalid";
                        }

                        word.append(arr[i]);
                    }
                }

                used[c - 'a'] = true;

                // 이전까지의 일반 단어 저장
                if (temp.length() > 0) {
                    list.add(temp.toString());
                    temp.setLength(0);
                }

                list.add(word.toString());

                // 규칙 2가 끝난 다음 위치부터 탐색
                idx = end + 1;
            }
        }

        // 마지막 일반 단어 저장
        if (temp.length() > 0) {
            list.add(temp.toString());
        }

        return String.join(" ", list);
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}