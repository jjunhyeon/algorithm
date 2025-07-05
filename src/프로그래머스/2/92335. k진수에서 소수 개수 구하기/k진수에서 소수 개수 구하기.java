
// 양의정수를 k 진수로 바꿨을 때, 변환된 수 안에 조건에 맞는 소수가 몇개인지 찾자
// 1. 양의 정수를 k 진수로 바꾸기
// 2. k진수에서 소수가 있는지 찾기(소수여부는 또 10진수로 확인한다)
// stack에 값을 하나씯 담는다
// 현재 스택에 담긴 값이 소수인지 확인한다.
// 소수라면 초기화, 이후 다음 넣기
import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 변환 완료
        String changeNumber = Long.toString(n,k); 
        String[] arr = changeNumber.split("0");
        // 0을 기준으로 구분해서 소수인지 판단하면 된다.
        for(String data: arr){
            if(data.equals("") || data.equals("1")) continue;
        
            long num= Long.parseLong(data);                       
            if(isPrimeNumber(num)){
                answer++;
            }
        }    
        
        return answer;
    }
    
    
    // 소수 판별기
    public boolean isPrimeNumber(long k){
        
        for(int i=2;i<=Math.sqrt(k); i++){
            if(k%i==0){
                return false;
            }
        }
        
        return true;
    }
}