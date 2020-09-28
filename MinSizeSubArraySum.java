class MinSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        
        //Stores the min size of subarray
        int result = Integer.MAX_VALUE;
        
        //It will store sum of subArray
        int resultSum = 0;
        
        //It will be the left pointer, the start of the subarray
        int left = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            resultSum += nums[i];
            
            //We have found a subarray >= s
            while(resultSum >= s){
                
                //We want the min size subarray >= s
                result = Math.min(result, i + 1 - left);
                
                //We remove the leftmost number and try adding next elements to see >=s
                resultSum -= nums[left];
                
                left++;
            }
            
        }
        
        return (result == Integer.MAX_VALUE) ? 0 : result;
        
    }
}
