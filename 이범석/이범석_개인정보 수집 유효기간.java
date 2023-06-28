import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
	    public Integer[] solution(String today, String[] terms, String[] privacies) {
	        ArrayList<Integer> arrList = new ArrayList<>();
	        
	        Map<Character, Integer> pair = new HashMap<>();
	        for(String a: terms) {
	        	char key = a.charAt(0);
	        	int value = Integer.parseInt(a.substring(2));
	        	pair.put(key, value);
	        }
	        int todayValue = Integer.parseInt(today.substring(0, 4))*12*28
	        		+(Integer.parseInt(today.substring(5, 7))-1)*28
	        		+Integer.parseInt(today.substring(8, 10));
	        
	        
	        
	        int size = privacies.length;
	        for(int i=0;i<size;i++){
	        	int plusMonth = pair.get(privacies[i].charAt(11));	        	
	        	int privaciesValue = Integer.parseInt(privacies[i].substring(0, 4))*12*28
		        		+(Integer.parseInt(privacies[i].substring(5, 7))-1)*28
		        		+Integer.parseInt(privacies[i].substring(8, 10))
		        		+plusMonth*28-1;
	        	if(todayValue>privaciesValue) {
	        		arrList.add(i+1);
	        	}
	        	
	        }
	        Integer[] answer =  arrList.toArray(new Integer[0]);
	        
	        
	        return answer;
	    }
	}
