class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        
        while(right < sequence.length) {
            
            if(sum == k) {
                if(right - left < min){
                    min = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            }
            
            else if(sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
            else if(sum > k) {
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}