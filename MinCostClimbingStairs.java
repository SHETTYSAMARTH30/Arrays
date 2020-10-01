class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        
        int len = cost.length;
        
        for(int i = 2; i < len; i++){
            
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        
        //We can climb 1 step or 2 step at a time. So we will use min cost to climb to top ie from last or 2nd last floor.
        return Math.min(cost[len - 1],cost[len - 2]);
    }
}
