class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;

        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String nowString = s.substring(0,i);
            for(int j=i; j<=s.length(); j+=i){ // i의 덩어리만큼 더해서 비교해야함

                int endIdx = Math.min(i+j, s.length());
                String compare = s.substring(j,endIdx);
                if(nowString.equals(compare)){
                    count++;
                } else {
                    if(count >= 2){
                        sb.append(count);
                    }
                    sb.append(nowString);
                    nowString = compare; // 마지막 인덱스일때 한번 더 더해야함
                    count = 1; // 리셋
                }
            }
            sb.append(nowString);
            answer = Math.min(sb.length(), answer); // 한사이클 돌고 최소 값으로 초기화 시킴
        }
        return answer;
    }
}