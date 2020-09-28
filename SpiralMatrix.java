class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        
        if(matrix.length == 0 || matrix == null)
            return list;
        
        //Lets us know which direction we travelling
        int dir = 0;
        
        //Will point to first and last row
        int top = 0, bottom = matrix.length - 1;
        
        //Will point to first and last column
        int left = 0, right = matrix[0].length - 1;
        
        //We will add all elements on top boundary, then right, then bottom, then left boundary. After that we go inside and do same.
        while(top <= bottom && left <= right){
            
            //First we cover all elements lying along the top boundary
            if(dir == 0){
                
                for(int i = left; i <= right; i++)
                    list.add(matrix[top][i]);
                
                //top will cover next row
                top++;
            }
            //We will cover right boundary
            else if(dir == 1){
                
                for(int i = top; i <= bottom; i++)
                    list.add(matrix[i][right]);
                
                //right will cover next column
                right--;
            }
            //We will cover bottom boundary
            else if(dir == 2){
                
                for(int i = right; i >= left; i--)
                    list.add(matrix[bottom][i]);
                
                //bottom will cover 2nd last row
                bottom--;
            }
            //We will cover Left boundary
            else{
                
                for(int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);
                
                //Left will cover left boundary
                left++;
            }
            
            //We will increment dir after each boundary
            dir = (dir + 1) % 4;
        }
        
        return list;
        
    }
}
