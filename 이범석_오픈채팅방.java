import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> ids = new HashMap<>();
        int recordLength = record.length;
        int count=0;
        String[][] stringMatrix = new String[recordLength][3];

        for(int i=0; i<recordLength; i++) {
            stringMatrix[i] = record[i].split(" ");
            if(!stringMatrix[i][0].equals("Change")) count++;
            if(stringMatrix[i][0].equals("Leave")) continue;
            ids.put(stringMatrix[i][1], stringMatrix[i][2]);
        }

        String[] answer = new String[count];
        count=0;
        for(int i=0; i<recordLength; i++) {
            String output=null;
            if(stringMatrix[i][0].equals("Enter")) {
                output = ids.get(stringMatrix[i][1])+"님이 들어왔습니다.";
            } else if(stringMatrix[i][0].equals("Leave")) {
                output = ids.get(stringMatrix[i][1])+"님이 나갔습니다.";
            }
            if(output!=null) {
                answer[count] = output;
                count++;
            }
        }
        return answer;
    }
}
