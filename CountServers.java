class CountServers {
    public int countServers(int[][] grid) {
        
        int totalServers = 0;
        
        int rowCount[] = new int[grid.length];
        int colCount[] = new int[grid[0].length];
        
        
        for(int row=0; row < grid.length; row+=1){
            for(int col=0; col<grid[0].length; col+=1){
                if(grid[row][col] == 1){
                    
                    rowCount[row]+=1;
                    colCount[col]+=1;
                    totalServers+=1;
                }
            }
            
        }
        
        for(int row=0; row < grid.length; row+=1){
            for(int col=0; col < grid[0].length; col+=1){
                if(grid[row][col] == 1){
                    
                    if(rowCount[row] == 1 && colCount[col] == 1)
                        totalServers-=1;
                }
            }
        }
        
        return totalServers;
    }
}
