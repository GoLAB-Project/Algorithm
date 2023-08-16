import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
	    int answer = -1, max = 0;
	    long sum = 0, sumQueue1 = 0, sumQueue2 = 0;
	        
	    Queue<Integer> que1 = new LinkedList<>();
	    Queue<Integer> que2 = new LinkedList<>();
	        
	    for(int i=0; i<queue1.length; i++) {
	        if(max<queue1[i]) max = queue1[i];
	        if(max<queue2[i]) max = queue2[i];
	        sumQueue1 += queue1[i];
	        sumQueue2 += queue2[i];
	        	
	        sum = sum + queue1[i] + queue2[i];
	        que1.add(queue1[i]);
	        que2.add(queue2[i]);
	    }
	        
	    if(sum%2==1) return answer;
	    long targetNum = sum/2;
	    if(max>targetNum) return answer;
	        
	    answer = 0;
	    boolean possible = false;
	    while(answer<=3*queue1.length) { // 이 횟수를 바꾸니 테스트 1이 성공으로 바뀜.. 왜인지 모름
	        if(sumQueue1==sumQueue2) {
	        	possible = true;
	        	break;
	        }
	        else if (sumQueue1>sumQueue2) {
				int movedNum = que1.poll();
				sumQueue1 -= movedNum;
				que2.add(movedNum);
				sumQueue2 += movedNum;
			}else {
				int movedNum = que2.poll();
				sumQueue2 -= movedNum;
				que1.add(movedNum);
				sumQueue1 += movedNum;
			}
	        answer++;
	    }
	    if(!possible) answer = -1;
	    return answer;
	}
}
