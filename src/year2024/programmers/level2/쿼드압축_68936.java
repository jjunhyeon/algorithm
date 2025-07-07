package year2024.programmers.level2;

class 쿼드압축_68936 {
    public int[] answer = new int[2];
    public int[] solution(int[][] arr) {       
        int size = arr.length;
        
        dfs(0,0,size,arr);
        
        return answer;
    }
    public void dfs(int x, int y,int size, int[][] arr){
        
        if(isZipable(x,y,size,arr,arr[x][y])){
            // 만약 끝이라면
            if(arr[x][y] == 0){
                answer[0] ++;
                
            } else {
                answer[1] ++;
            }
            return;
        }
        dfs(x ,y ,size/2,arr);
        dfs(x , y + size/2,size/2 ,arr);
        dfs(x + size/2, y + size/2, size/2, arr);
        dfs(x + size/2, y , size/2, arr);        
        
    }
    
    public boolean isZipable(int x, int y,int size, int[][] arr,int value){
        for(int i = x; i<x + size; i++){
            for(int j=y; j<y + size; j++){
                if(value != arr[i][j]) return false;
            }
        }
        return true;
    }
}
