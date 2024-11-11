class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int baseX =  bill[0];
        int baseY =  bill[1];
        
        int walX = wallet[0];
        int walY = wallet[1];
        
        int bigOne = 0;
        int smallOne = 0;
        if(baseX >= baseY){
            bigOne = baseX;
            smallOne =baseY;
        } else {
            bigOne = baseY;
            smallOne = baseX;
        }
        
        if((bigOne <= walX && smallOne <= walY) || (bigOne <= walY && smallOne <= walX)) return 0;
        
        while(true) {            
            if(bigOne >= smallOne){
                bigOne = bigOne / 2;
            } else {
                smallOne = smallOne / 2;
            }
            answer +=1;
            if(bigOne <= walX && smallOne <= walY) break;
            if(bigOne <= walY && smallOne <= walX) break;
        }
        return answer;
    }
}