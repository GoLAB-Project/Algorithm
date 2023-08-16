import java.util.*;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/118667
    두 큐 합 같게 만들기
        
    참고
      Streams
      https://velog.io/@sw_smj/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EA%B8%B0%EC%B4%88%EB%AC%B8%EB%B2%95-3-%EB%B0%B0%EC%97%B4-%EB%A6%AC%EC%8A%A4%ED%8A%B8%EC%9D%98-%ED%95%A9%EA%B3%84-%EA%B5%AC%ED%95%98%EA%B8%B0
*/

class Solution {
    public int solution(int[] queue1, int[] queue2) {
	int answer = 0;
	long q1hap, oldHap, newHap = 0;
		
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
        
	q1hap = Arrays.stream(queue1).sum();
	oldHap = q1hap + Arrays.stream(queue2).sum();

    // 1. 각 큐의 원소 합을 같게 만들 수 없는 경우
	if (oldHap % 2 == 1) return -1;
        
    // 2. 각 큐의 원소 합이 같은 경우
	newHap = oldHap / 2;
        
	for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
	}
        
    // 합이 같아질 때까지 반복
	int temp = 0;

	while (q1hap != newHap) {
        if (q1hap < newHap) {
	    temp = q2.poll();
	    q1.offer(temp);
	    q1hap += temp;
	} else {
	    temp = q1.poll();
	    q2.offer(temp);
	    q1hap -= temp;
	}
	answer++;      	
        // 큐1, 2의 길이는 같고 2번씩 반복하면 처음과 같아지므로 불가능한 경우
        if (answer >= (queue1.length * 2) * 2) 
            return -1;
	}
	    
	return answer;
    }
}
