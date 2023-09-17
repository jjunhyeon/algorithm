class Solution {
    public static int answer = 0;
    public int solution(int[] numbers, int target) {
        int[] result = new int[numbers.length];
        dfsSolution(0, numbers, target,result);
        return answer;
    }
    
    public static void dfsSolution(int depth, int[] numbers, int target, int[] result){

        if(depth == numbers.length ){
            int sum = 0;
            for(int i=0; i< result.length; i++){
                sum += result[i];
            }
            if(sum == target){
                answer += 1;
            }
            return;
        }

        result[depth] =  numbers[depth];
        dfsSolution(depth + 1, numbers, target, result);
        result[depth] = -numbers[depth];
        dfsSolution(depth + 1, numbers, target, result);
    }
}