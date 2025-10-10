import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int n = board.length;

        for (int move : moves) {
            int col = move - 1;

            for (int i = 0; i < n; i++) {
                int doll = board[i][col];
                if (doll == 0) continue;

                board[i][col] = 0;

                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }
                break;
            }
        }
        return answer;
    }
}