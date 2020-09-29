class MaxIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxResult = 0;
        
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j < grid[0].length; j++){
                
                //We found a land, hence check whether it is island or not by DFS
                if(grid[i][j] == 1){
                    
                    maxResult = Math.max(maxResult, dfs(grid, i, j));
                }
            }
        }
        
        return maxResult;
    }
    
    public int dfs(int[][] grid, int r, int c){
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        
        return 1 + (dfs(grid,r+1,c) + dfs(grid,r-1,c) + dfs(grid,r,c-1) + dfs(grid,r,c+1));
    }
}
