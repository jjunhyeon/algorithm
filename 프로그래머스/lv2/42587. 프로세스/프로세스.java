import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> myq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            myq.offer(priorities[i]);
        }
        
		while(!myq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == myq.peek()) {
					myq.poll();
					answer++;
					if(i == location) return answer;
				}
			}
		}
          
        return answer;
    }
     
}