class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int baseX =  bill[0];
        int baseY =  bill[1];
        
        int walX = wallet[0];
        int walY = wallet[1];
        
        int bigOne = Math.max(baseX,baseY);
        int smallOne = Math.min(baseX,baseY);
        
        while(true) {   
            if(bigOne <= walX && smallOne <= walY) break;
            if(bigOne <= walY && smallOne <= walX) break;
            if(bigOne >= smallOne){
                bigOne = bigOne / 2;
            } else {
                smallOne = smallOne / 2;
            }
            answer +=1;
        }
        return answer;
    }
}