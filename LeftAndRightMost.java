class LeftAndRightMost {
    public int[] searchRange(int[] nums, int target) {
        
        //If we dont find index return this
        int result[] = {-1,-1};
        
        int leftMostIndex = findIndex(nums, target, true);
        
        //If the abv result is incorrect
        // assert that `leftMostIndex` is within the array bounds and that `target`
        // is actually in `nums`.
        if(leftMostIndex == nums.length || nums[leftMostIndex] != target)
            return result;
        
        //If the abv result is correct then definitely we have last index
        int rightMostIndex = findIndex(nums, target, false) - 1;
        
        result[0] = leftMostIndex;
        result[1] = rightMostIndex;
        
        return result;
        
    }
    
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    public int findIndex(int[] nums, int target, boolean left){
        
        int lo = 0;
        int hi = nums.length;
        
        while(lo < hi){
            
            int mid = lo + (hi - lo)/2;
            
            //We need to go left so that we find the leftmost index
            if(nums[mid] > target || (left && (nums[mid] == target)))
                hi = mid;
            
            //We need to move right
            else{
                lo = mid + 1;
                
            }
        }
        
        return lo;
    }
}
