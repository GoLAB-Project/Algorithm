import java.util.Iterator;
import java.util.LinkedList;

/* 
 * 1. 최악의 경우 10만 * 30^2 = 90,000,000회 실행되는 알고리즘
 * 2. LinkedList를 priority가 있는 queue처럼 사용하여 구현함
 * 3. Iterator는 순회 중 요소를 제거할 수 있는 가장 안전한 방법이라고 함(출처: 공식 문서)
 * 4. 캐시의 크기가 0일 때는 예외 처리를 통해 O(1)로 진행함
 */
class Solution {
    static LinkedList<String> cache = new LinkedList<>();
    
    static public int LRU(int cacheSize, String city) {
        Boolean isMiss = true;
        
        int step = 0;
        Iterator<String> iter = cache.iterator();
        
        while(iter.hasNext()) {
            if(step == cacheSize) break; // Cache size exceed
            
            String cmpCity = iter.next();
            if(city.equals(cmpCity)) {
                isMiss = false;
                iter.remove();
                cache.push(city);
                break;
            }
            
            ++step;
        }
        
        if(isMiss) {
            if(cache.size() == cacheSize) cache.removeLast(); // Cache size exceed
            cache.push(city);
            return 5;
        }
        
        return 1;
    }
    
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length; // Cache size zero exception
        
        int answer = 0;
        for(String city : cities) {
            answer += LRU(cacheSize, city.toLowerCase()); // Case insensitive
        }
        
        return answer;
    }
}