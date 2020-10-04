class JumpGame2 {
    public int jump(int[] nums) {
        
        int pos = 0;
        
        int dest = 0;
        
        int jumps = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            
            dest = Math.max(dest, nums[i] + i);
            
            if(pos == i){
                
                pos = dest;
                jumps++;
            }
        }
        
        return jumps;
        
    }
}
