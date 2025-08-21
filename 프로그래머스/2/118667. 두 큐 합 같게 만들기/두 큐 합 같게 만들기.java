import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        Queue<Long> queue1 = new LinkedList<>();
        Queue<Long> queue2 = new LinkedList<>();
        
        for (long n1 : arr1) {
            queue1.add(n1);
        }
        
        for (long n2 : arr2) {
            queue2.add(n2);
        }
        
        long sum1 = 0;
        long sum2 = 0;
        long diff = 0;
        int answer = 0;
        
        // 큐1의 합 구하기
        for (long q1 : queue1) {
            sum1 += q1;
        }
        
        // 큐2의 합 구하기
        for (long q2 : queue2) {
            sum2 += q2;
        }
        
        while(sum1 != sum2) {
            
            if(answer > (queue1.size() + queue2.size())*4) {
                answer = -1;
                break;
            }
            
            if(sum1 < sum2) {
                long num = queue2.peek();
                sum1 += num;
                sum2 -= num;
                queue1.offer(queue2.poll());
            }
            else {
                long num = queue1.peek();
                sum1 -= num;
                sum2 += num;
                queue2.offer(queue1.poll());
            }
            answer++;            
        }
        
        return answer;
    }
}