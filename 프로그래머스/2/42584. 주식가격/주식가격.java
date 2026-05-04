class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length - 1; i++) {
            int temp = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] > prices[j]) {
                    temp = j - i;
                    break;
                }
                else temp++;
            }
            answer[i] = temp;
        }
        return answer;
    }
}