class Solution {
  static boolean flag = false;
  static String binaryString;
    
	public int[] solution(long[] numbers) {
	    int inputSize = numbers.length;
	    int[] answer = new int[inputSize];
	    	
	    for(int i=0; i<inputSize; i++) {
	    	// 입력값을 2진수 String 으로 변경 후, 뒤집기
	    	binaryString = Long.toBinaryString(numbers[i]);
	    	StringBuffer sb = new StringBuffer(binaryString);
	    	binaryString = sb.reverse().toString();
	    		
	    		
	    	// 2진수의 깊이, 길이 찾기
	    	int binaryLength = binaryString.length();
	    	int deep = 1;
            while(((int)Math.pow(2, deep) -1) < binaryLength) {
    			deep++;
    		}
                
            // binaryString 에 뒤에 문자열 붙이기
	    	int add = ((int)Math.pow(2, deep))-1-binaryLength;
	    	String addString = "";
            if(add>0){
                addString = "0".repeat(add);
	    		binaryString = binaryString+addString;    
            }	
	    		
	    	// 최상위 부모 노드 찾기
	    	// 깊이 1->0   깊이 2->1   깊이 3->3   깊이 4->7 ...
	    	int topNode = (int)Math.pow(2, deep-1)-1;
	    	
            // getAnswer 함수 사용
	    	flag=false;
	    	getAnswer(topNode, deep);
	    	answer[i]=(flag)?0:1;	
            
	    	}
	    	
	        return answer;
	    }
    
    private static void getAnswer(int parentNode, int nowDeep) {
        
		int gap = (int)Math.pow(2, nowDeep-2);
		int leftIndex = parentNode-gap;
		int rightIndex = parentNode+gap;
		boolean nowCanHaveChild = (binaryString.charAt(parentNode)=='1')?true:false;
		boolean leftNode = (binaryString.charAt(leftIndex)=='1')?true:false;
		boolean rightNode = (binaryString.charAt(rightIndex)=='1')?true:false;	
				
		if(!nowCanHaveChild && (leftNode||rightNode)) {
			flag = true;
			return;
		}
				
		if(nowDeep>=3) {
			getAnswer(leftIndex, nowDeep-1);
			getAnswer(rightIndex, nowDeep-1);
		}
		return;
        
    }
}
