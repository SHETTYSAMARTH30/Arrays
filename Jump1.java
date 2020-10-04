class Jump1 {
    public boolean canJump(int[] nums) {
        
        //This is greedy method
        
        int lastFavorablePos = nums.length - 1;
        
        //Favorable position is an index from which we can reach the last index
        for(int i = nums.length - 1; i >= 0; i--){
            
            //If we can reach the Favorable position then we can reach last index hence we update lastFavorablePos
            if((i + nums[i]) >= lastFavorablePos){
                
                lastFavorablePos = i;
            }
        }
        
        //If it is 0 that means we can reach the last index from 0
        return lastFavorablePos == 0;
        
    }
}
