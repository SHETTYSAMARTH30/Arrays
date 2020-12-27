class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        
        //It stores all the diagonal values in ascending order with their id = i-j
        //All the diagonal elements have same i-j value hence we take that as id
        Map<Integer, PriorityQueue<Integer>> diagonal = new HashMap<>();
       
        //Rows
        int n = mat.length;
        
        //Cols
        int m = mat[0].length;
        
        //We insert each of the diagonal values in the PriorityQueue
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < m; j++){
                
                //First create queue
                diagonal.putIfAbsent(i - j, new PriorityQueue<Integer>());
                
                //Add values in it
                diagonal.get(i - j).add(mat[i][j]);
            }
        }
        
        //We remove each element from queue and again add them to matrix
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < m; j++){
                
                //We remove smallest element currently present in the queue
                mat[i][j] = diagonal.get(i - j).poll();
            }
        }
        
        return mat;
        
    }
}
