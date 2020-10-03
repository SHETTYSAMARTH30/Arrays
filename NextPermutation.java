class NextPermutation {
    public void nextPermutation(int[] nums) {
        
        /* There are 4 steps to find the next permutation
        1) Find the number nums[i] such that all the numbers after nums[i] ie nums[i+1] to num.length - 1 are in decreasing order
        2) Find a number j from nums[i+1] to nums.length-1 such that j is next greater element after nums[i]
        3) Swap j and nums[i]
        4) After swapping, the order from nums[i+1] to end will still remain the same as before ie decreasing order. So reverse all elements from nums[i+1] to nums.length-1 (Ascending order) */
        
        int n = nums.length;
        
        //Step1
        
        int i = n - 2;
        
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        //Step2
        if(i >= 0){
            
            //Find next greater element from i
            int j = nums.length - 1;
            
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            
            //Step3
            swap(nums, i, j);
        }
        
        //Step4- Reverse all the elements from nums[i+1] to nums.length
        reverse(nums, i+1, n - 1);
        
    }
    
    public void reverse(int[] nums, int lo, int hi){
        
        while(lo < hi){
            
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}
