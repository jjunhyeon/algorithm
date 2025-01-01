package programmers.level2;

/*
* 타겟넘버
* dfs
* */
public class 타겟넘버_43165 {
    public static int answer = 0;
    public static void main(String[] args){
        int[] numbers = {4,1,2,1};
        int target = 4;
        int[] result = new int[numbers.length];

        dfsSolution(0, numbers, target,result);
        System.out.println("ans ::" + answer);
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

        // depth 활용 result[depth] 에만 +-1 호출
        result[depth] =  numbers[depth];
        dfsSolution(depth + 1, numbers, target, result);
        result[depth] = -numbers[depth];
        dfsSolution(depth + 1, numbers, target, result);
    }
}
