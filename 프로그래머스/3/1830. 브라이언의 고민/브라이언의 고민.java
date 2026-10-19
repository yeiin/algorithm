import java.util.*;

public class Solution {

    public String solution(String sentence) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = sentence.toCharArray();

        String invalid = "invalid";
        int size = arr.length;

        // 소문자 등장 횟수 기록
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        // can[i]: i부터 끝까지 올바르게 해석할 수 있는지
        boolean[] can = new boolean[size + 1];

        // next[i]: 현재 단어를 처리한 다음 위치
        int[] next = new int[size];

        // word[i]: i에서 시작하는 규칙 적용 단어
        String[] word = new String[size];

        can[size] = true;

        // 뒤에서부터 가능한 해석 확인
        for (int i = size - 1; i >= 0; i--) {

            if (Character.isUpperCase(arr[i])) {

                // 대문자 + 소문자: 규칙 1 확인
                int end = checkRule1(arr, map, i);

                if (end != -1 && can[end + 1]) {
                    can[i] = true;
                    next[i] = end + 1;
                    word[i] = makeWord(arr, i, end);
                }
                else if (can[i + 1]) {
                    // 일반 대문자로 처리
                    can[i] = true;
                    next[i] = i + 1;
                }

            } else {

                // 소문자로 시작: 규칙 2 확인
                if (map.get(arr[i]) != 2) {
                    continue;
                }

                int end = sentence.indexOf(arr[i], i + 1);

                if (end != -1
                        && checkRule2(arr, map, i, end)
                        && can[end + 1]) {

                    can[i] = true;
                    next[i] = end + 1;
                    word[i] = makeWord(arr, i, end);
                }
            }
        }

        if (!can[0]) return invalid;

        // 원래 문자열 복원
        int idx = 0;
        StringBuilder temp = new StringBuilder();

        while (idx < size) {

            if (word[idx] == null) {
                // 규칙 없는 일반 대문자
                temp.append(arr[idx]);

            } else {
                // 이전 일반 문자열 저장
                if (temp.length() > 0) {
                    list.add(temp.toString());
                    temp.setLength(0);
                }

                // 규칙을 적용한 단어 저장
                list.add(word[idx]);
            }

            idx = next[idx];
        }

        if (temp.length() > 0) {
            list.add(temp.toString());
        }

        return String.join(" ", list);
    }

    // 규칙 1: 대문자 소문자 대문자 소문자 ... 대문자
    private int checkRule1(
            char[] arr,
            HashMap<Character, Integer> map,
            int start) {

        int size = arr.length;

        if (start + 1 >= size) return -1;
        if (!Character.isLowerCase(arr[start + 1])) return -1;

        char mark = arr[start + 1];
        int count = map.get(mark);

        int end = start + count * 2;

        if (end >= size) return -1;

        for (int i = start; i <= end; i++) {

            if ((i - start) % 2 == 0) {
                // 대문자 위치
                if (!Character.isUpperCase(arr[i])) {
                    return -1;
                }
            } else {
                // 소문자 위치
                if (arr[i] != mark) {
                    return -1;
                }
            }
        }

        return end;
    }

    // 규칙 2: 소문자 + 단어 + 소문자
    private boolean checkRule2(
            char[] arr,
            HashMap<Character, Integer> map,
            int start,
            int end) {

        if (end <= start + 1) return false;

        char inner = 0;

        // 규칙 2 내부 확인
        for (int i = start + 1; i < end; i++) {

            if (Character.isLowerCase(arr[i])) {

                if (inner == 0) {
                    inner = arr[i];
                }
                else if (inner != arr[i]) {
                    return false;
                }

            } else if (!Character.isUpperCase(arr[i])) {
                return false;
            }
        }

        // 내부에 소문자가 없으면 규칙 2만 적용
        if (inner == 0) {
            return true;
        }

        // 내부에 소문자가 있으면 규칙 1 중첩
        int length = end - start - 1;

        if (length % 2 == 0) return false;

        // 내부 소문자 등장 횟수 확인
        if (map.get(inner) != length / 2) {
            return false;
        }

        for (int i = start + 1; i < end; i++) {

            if ((i - start - 1) % 2 == 0) {
                if (!Character.isUpperCase(arr[i])) {
                    return false;
                }
            } else {
                if (arr[i] != inner) {
                    return false;
                }
            }
        }

        return true;
    }

    // 소문자 제거 후 단어 복원
    private String makeWord(char[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (Character.isUpperCase(arr[i])) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}