import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) heap.offer(scoville[i]);
        
        while(!heap.isEmpty()) {
            if(heap.peek() >= K) break;
            
            if(heap.size() <= 1) {
                answer = -1;
                break;
            }
            int cur = heap.poll();
            int nxt = heap.poll();
            heap.offer(cur+nxt*2);
            answer += 1;
        }
        return answer;
    }
}