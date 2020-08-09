class MaxNonOverlappingSubArr {
    public int maxNonOverlapping(int[] nums, int target) {
        
        //Stores the sum and total number of subarrays upto i
        Map<Integer,Integer> map = new HashMap();
        
        int sum = 0;
        int res = 0;
        
        //Initally sum will be 0 and count will also be 0
        map.put(0,0);
        
        for(int num : nums){
            
            sum += num;
            
            //We have found a subarray hence we add 1 to the count upto the start of subarray
            if(map.containsKey(sum - target)){
                
                //It will avoid the count of bigger subarray if there is mul small subarrays in between
                res = Math.max(res, map.get(sum - target) + 1);
            }
            
            map.put(sum,res);
        }
        
        return res;
    }
}
