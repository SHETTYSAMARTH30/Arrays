class SumNZero {
    public int[] sumZero(int n) {
        
        int result[] = new int[n];
        
        //If n is 1 then we can only put 0
        if(n == 1)
            return result;
        
        //If n is even then we can return n elements (-1,1,-3,3) but if odd then to make total zero we need to add 0
        int i = (n % 2 == 0) ? 1 : 0;
        
        //Iterate through n
        for(; i < n; i += 2){
            
            //If n is add, we add 0 in start
            if(i == 0){
                
                result[i] = 0;
                continue;
            }
            
            //We put -i and +i of every number so that it makes 0 till we get n total numbers in array
            result[i] = -i;
            result[i - 1] = i;
        }
        
        return result;
        
    }
}
