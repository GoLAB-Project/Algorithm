import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        int citiesSize = cities.length;
	        Queue<String> cacheQueue = new LinkedList<>();
                if(cacheSize==0) return 5*citiesSize; // 캐쉬 사이즈가 0일때
	        
	        for(int i=0; i<citiesSize; i++) {
	        	boolean isexist = cacheQueue.remove(cities[i].toLowerCase());
	        	if(isexist) answer+=1;
	        	else {
	        		if(cacheQueue.size()==cacheSize) cacheQueue.poll();
	        		answer+=5;
	        	}
	        	cacheQueue.add(cities[i].toLowerCase());	        	
	        }
	        return answer;
	}
}
