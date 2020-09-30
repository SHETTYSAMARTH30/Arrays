class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        //We will sort the array
        Arrays.sort(nums);
        
        //4Sum hence 4
        return kSum(nums, target, 0, 4);
        
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        
        List<List<Integer>> res = new ArrayList<>();
        
        //Either we have completed iterating entire loop
        //If first element*4 is greater than target or last element*4 is less than target then stop
        if(start == nums.length || nums[start]*k > target || nums[nums.length - 1]*k < target)
            return res;
        
        //Then its twoSum
        if(k == 2)
            return twoSum(nums, target, start);
        
        for(int i = start; i < nums.length; i++){
            
            //If we find repeating number then we ignore it
            if(i == start || nums[i-1] != nums[i]){
                
                //We perform 3Sum next if we are currently doing 4Sum. Hence we reduce target by nums[i] and send k-1. We try to find 3 number that equal to target from start+1 to end.
                List<List<Integer>> set = kSum(nums, target - nums[i], i+1, k-1);
                
                for(List<Integer> s : set){
                    
                    //We create a new list and add current number to it.
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    
                    //We fetch the prev added list and add all the number from the list that we got from recursive call (kSum) to the fetched list. The prev recursive call result will be appended after nums[i]
                    res.get(res.size()-1).addAll(s);
                    
                } 
                
            }
        }
        
        return res;
            
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        
        List<List<Integer>> res = new ArrayList<>();
        
        int lo = start;
        int hi = nums.length - 1;
        
        while(lo < hi){
            
            int sum = nums[lo] + nums[hi];
            
            //We ignore repeating numbers
            if(sum < target || (lo > start && nums[lo] == nums[lo-1]))
                lo++;
            
            //We ignore repeating numbers
            else if(sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi+1]))
                hi--;
            
            //If we find target the store the 2 number in the result
            else{

                res.add(Arrays.asList(nums[lo],nums[hi]));
                
                //After adding 2 number into list we move forward
                lo++;
                hi--;
            }
        }
    
        return res;
    }
}
