import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; // 작업 횟수
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        long sumTarget = 0;
        long sumQue1 = 0;
        
        for(int i=0;i<queue1.length;i++){
            sumTarget+=queue1[i]+queue2[i];
            sumQue1 += queue1[i];
        }
        
        if(sumTarget %2 == 1) return -1; //두 개 합 홀수면 같을 수 없다

        
        sumTarget/=2; // 목표 합
        
                
        for(int i=0;i<queue1.length;i++){ //큐에 담아준다
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }
        
        while(sumQue1 != sumTarget){ //값이 같아지면 출력
            if(answer > (queue1.length * 3)){ // 횟수 다 돌았는데 어떤 방법으로도 안될 경우
                return -1;
            }
            
            else if(sumQue1 > sumTarget){
                int temp = que1.poll();
                sumQue1-=temp;
                que2.add(temp);
            }
            else{
                int temp = que2.poll();
                sumQue1 += temp;
                que1.add(temp);
            }
            answer++;
        }
        
        return answer;
    }
}
