/**
		https://school.programmers.co.kr/learn/courses/30/lessons/42884
		단속카메라

        유사문제
        정올 - 1828 냉장고
        https://www.jungol.co.kr/problem/1828
**/

import java.util.*;

/*
class Road {
	int start, end;

	public Road(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
*/

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // end 기준 오름차순
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        //첫번째 지점부터 시작하므로 +1
        int cameraPoint = routes[0][1];
        answer++;
        
        // 두번째부터 시작이므로 1부터, 겹치지 않으면 새로운 지점에 설치
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > cameraPoint) {
                answer++;
                cameraPoint = routes[i][1];
            }
        }
        
        return answer;
    }
}
