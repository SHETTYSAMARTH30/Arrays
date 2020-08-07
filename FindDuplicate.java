class FindDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int n : nums){
            
            //We have came across this number before hence it is -ve
            if(nums[Math.abs(n) - 1] < 0){
                
                ans.add(Math.abs(n));
            }   
            
            //We mark the number as visited
            nums[Math.abs(n) - 1] *= -1;
        }
        
        return ans;
    }
}
