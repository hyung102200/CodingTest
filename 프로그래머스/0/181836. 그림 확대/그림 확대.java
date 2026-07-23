class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        
        for(int i=0; i<picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] arr = picture[i].toCharArray();
            
            for(char c : arr) {
                for(int j=0; j<k; j++) {
                    sb.append(c);
                }
            }
            for(int j=0; j<k; j++) {
                answer[i*k + j] = sb.toString();
            }
        }
        
        return answer;
    }
}