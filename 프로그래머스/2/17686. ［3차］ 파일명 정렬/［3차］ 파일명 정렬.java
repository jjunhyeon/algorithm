// 09:28 시작
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String> answerList = new ArrayList<String>();        
        answerList.addAll(Arrays.asList(files));
        Collections.sort(answerList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                
                int indexOfFirstDigitS1 = 0;
                int indexOfFirstDigitS2 = 0;         
                
                int indexOfLastNumberS1 = 0;
                int indexOfLastNumberS2 = 0;
                
                for(int i=0; i<s1.length(); i++){
                    char c = s1.charAt(i);
                    if(indexOfFirstDigitS1 == 0 && Character.isDigit(c)){
                        indexOfFirstDigitS1 = i;
                        int lt = indexOfFirstDigitS1;
                        while(lt < s1.length()){
                            char d = s1.charAt(lt);
                            // 다시 숫자에서 벗어나는 지점 확인
                            if(!Character.isDigit(d)){
                               indexOfLastNumberS1 = lt;
                               break;
                            }
                            
                            if(lt == s1.length() - 1){
                              indexOfLastNumberS1 = lt+1;
                               break;
                            }
                            lt++;
                        }
                    }
                }
                
                for(int j=0; j<s2.length(); j++){
                    char c = s2.charAt(j);
                    if(indexOfFirstDigitS2 == 0 && Character.isDigit(c)){
                        indexOfFirstDigitS2 = j;
                        int lt = indexOfFirstDigitS2;
                        while(lt < s2.length()){
                            char d = s2.charAt(lt);
                            // 다시 숫자에서 벗어나는 지점 확인
                            if(!Character.isDigit(d)){
                               indexOfLastNumberS2 = lt;
                               break;
                            }
                            
                            if(lt == s2.length() - 1){
                               indexOfLastNumberS2 = lt+1;
                               break;
                            }
                            lt ++;
                        }
                    }
                }
                
                String headS1 = s1.substring(0,indexOfFirstDigitS1);
                String headS2 = s2.substring(0,indexOfFirstDigitS2);
                
                String NumberS1 = s1.substring(indexOfFirstDigitS1,indexOfLastNumberS1);
                String NumberS2 = s2.substring(indexOfFirstDigitS2,indexOfLastNumberS2);
                
                if(NumberS1.length() > 5){
                    NumberS1 = NumberS1.substring(0,5);
                }
                
                if(NumberS2.length() > 5){
                    NumberS2 = NumberS2.substring(0,5);
                }
                
                int headResult = headS1.compareToIgnoreCase(headS2);
                
                
                if(headResult == 0){
                    int leftS1 = Integer.parseInt(NumberS1);
                    int rightS2 = Integer.parseInt(NumberS2);
                    if(leftS1 > rightS2){
                        return 1;
                    } else if(leftS1 < rightS2){
                        return -1;
                    } else {
                        return 0;
                    }
                } 
                return headResult;
            }
        });
        return answerList.toArray(String[] :: new);
    }
}