import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> listAnswer = new ArrayList<>();
        Queue<MyCustom> mypq = new LinkedList();
        for(int i=0; i<progresses.length; i++){
            mypq.add(new MyCustom(i,progresses[i]));
        }
        

        while(!mypq.isEmpty()){
            int sum =0;
            
            for(int i=mypq.peek().index; i<progresses.length; i++){                
                // 100보다 작으면 speed + 
                if(progresses[i] < 100) progresses[i] += speeds[i];
                
                    
                if(progresses[i] >=  100){
                    boolean isPollable = true;
                    if(i != 0){
                        for(int j=i-1; j>=0; j--){
                            if(progresses[j] < 100) isPollable = false;    
                        }
                    }
                    
                    if(i == 0 || isPollable){
                        mypq.poll();
                        sum ++;  
                    }
                } 
            }

            if(sum != 0){
              listAnswer.add(sum);    
            }
        }

        return listAnswer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static class MyCustom {
        int index;
        int value;
        MyCustom(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}