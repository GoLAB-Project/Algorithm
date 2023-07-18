/**
		https://school.programmers.co.kr/learn/courses/30/lessons/17680
		[1차] 캐시 - 2018 KAKAO BLIND RECRUITMENT

    - LRU 캐시 교체 알고리즘
    캐시가 꽉 차 있으면 최근에 사용하지 않은 것을 교체
**/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        for(String city : cities){
            city = city.toLowerCase(); // newyork = NewYork 대소문자 구분x
            
            // 1. 캐시 사이즈가 0일 때
            if(cacheSize == 0) return cities.length * 5;
        
            // 2. 캐시에 있을 때
            if(q.contains(city)){
                q.remove(city); // 삭제 후 추가 : 최신화
                q.offer(city); 
                answer += 1;
                
            // 3. 캐시에 없을 때
            }else {
                if(q.size() == cacheSize) q.poll(); // 삭제 후 추가
                q.offer(city);
                answer += 5;
            }
        }

        return answer;
    }
}
