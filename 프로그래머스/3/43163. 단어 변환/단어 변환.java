import java.util.*;

class Solution {
    static String begin, target;
    static int size, wordsLen, answer;
    public int solution(String begin, String target, String[] words) {
        this.answer = Integer.MAX_VALUE;
        this.begin = begin;
        this.target = target;
        size = words.length;
        wordsLen = words[0].length();
        
        backTracking(0, begin, begin, words);
        
        if (answer == 2147483647) {
            return 0;
        }
        
        return answer;
    }
    
    public int backTracking(int idx, String curWord, String befWord, String[] words) {
        if (curWord.equals(target)) {
            answer = Math.min(answer, idx);

        }
        if (idx >= size) {
            return 0;
        }
        if (idx >= answer) {
            return 0;
        }
        
        for (String s : words) {
            if (!s.equals(curWord) && change(curWord, s)) {
                backTracking(idx + 1, s, curWord, words);
            }
        }
        return 0;
    }
    
    public boolean change(String a, String b) {
        int diff = 0;
        for (int i = 0; i < wordsLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}