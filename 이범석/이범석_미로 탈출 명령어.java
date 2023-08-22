class Solution {
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
	    String answer = "";
	    
	    int dN = Math.abs(x-r) + Math.abs(y-c);
	    if(dN>k || (k-dN)%2==1) {
	        answer = "impossible";
	        return answer;
	    }
	        
	    int nowX=y;
	    int nowY=x;
	        
	    for(int i=0; i<k;i++) {
	        dN = Math.abs(nowX-c) + Math.abs(nowY-r);
	        if(k-i!=dN) {
	        	if(nowY<r) {
	        		nowY++;
	        		answer+="d";
	        	}else if(nowY<n) {
	        		nowY++;
	        		answer+="d";
	        	}else if(nowX>c) {
	        		nowX--;
	        		answer+="l";
	        	}else if(nowX>1) {
	        		nowX--;
	        		answer+="l";
	        	}else {
	        		nowX++;
	        		answer+="r";
	        	}
	        }else {
	        	if(nowY<r) {
	        		nowY++;
	        		answer+="d";
	        	}else if(nowX>c) {
	        		nowX--;
	        		answer+="l";
	        	}else if(nowX<c) {
	        		nowX++;
	        		answer+="r";
	        	}else {
	        		nowY--;
	        		answer+="u";
	        	}
            }	
	    }
	    return answer;
	}
}
