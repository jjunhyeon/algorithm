
import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] map = {
                {1,1,1},//dia
                {5,1,1},//iron
                {25,5,1},//stone
        };

        // 한번에 myQ에 넣기
        Queue<String> myQ = Arrays.stream(minerals)
                .collect(LinkedList::new, Queue::offer, Queue::addAll);
        List<Mineral> totalInfo = new ArrayList<>();

        int idx = 0;
        int gok =picks[0]+picks[1]+picks[2];
        
        while(!myQ.isEmpty()){
            
             if(gok==0){
                break;
            }
            
            int division = (myQ.size() < 5) ? myQ.size() : 5;
            int cost = 0;
            String[] mineInfos = new String[5];
            gok--;
            for(int i=0; i<division; i++) {
                String mine = myQ.poll();
                if(mine.equals("diamond")){
                    cost += 25;
                    mineInfos[i] = mine;
                }
                else if(mine.equals("iron")){
                    cost += 5;
                    mineInfos[i] = mine;
                }
                else {
                    cost += 1;
                    mineInfos[i] = mine;
                }
            }
            totalInfo.add(new Mineral(cost,idx,mineInfos));
            idx ++;
        }

        // 그룹 코스트 별로 정렬
        Collections.sort(totalInfo, (a,b) -> (b.tCost - a.tCost));

        // 정렬한 totalinfo의 광물들을 기준으로 다이아 곡괭이부터 쓰며 처리한다.
        int result = 0;

        LinkedList<Integer> tool = new LinkedList<>();
        for(int i=1; i<=picks[0]; i++) {
            tool.addLast(0);
        }
        
        for(int i=1; i<=picks[1]; i++) {
            tool.addLast(1);
        }
        
        for(int i=1; i<=picks[2]; i++) {
            tool.addLast(2); 
        }
        
        if(tool.size() == 1){
            int len = (minerals.length < 5) ? minerals.length : 5;
            for(int i=0; i<len; i++){
                if("diamond".equals(minerals[i])){
                    result += map[tool.get(0)][0];
                } else if("iron".equals(minerals[i])){
                    result += map[tool.get(0)][1];
                } else {
                    result += map[tool.get(0)][2];
                }
            }
            return result;
        }
        
        
        int num = -1;
        for(int t : tool){
            num ++;
            if(num >= totalInfo.size()){
                break;
            }

            for(String target : totalInfo.get(num).mineInfo){
                if(target == null){
                    break;
                }
                if("diamond".equals(target)){
                    result += map[t][0];
                } else if("iron".equals(target)){
                    result += map[t][1];
                } else {
                    result += map[t][2];
                }
            }
           
        }
        
        return result;
    }
    
    static class Mineral {
        public int tCost;
        public int groupNumber;
        public String[] mineInfo;
        public Mineral(int tCost, int groupNumber, String[] mineInfo){
            this.tCost = tCost;
            this.groupNumber = groupNumber;
            this.mineInfo = mineInfo;
        }
    }
    
}