class RotateArray {
    public void rotate(int[] nums, int k) {
        
        //k can be a huge number
        k = k % nums.length;
        
        int len = nums.length - 1;
        
        //We reverse entire array
        reverse(nums, 0, len);
        
        //We reverse first k elements
        reverse(nums, 0, k - 1);
        
        //We reverse last n-k elements
        reverse(nums, k, len);
        
    }
    
    public void reverse(int[] nums, int start, int end){
        
        //We reverse all the elements between start and end position inclusive
        while(start < end){
            
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }  
        
    }
}
