class SumOf2Num {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        int n = A.length;
        
        //We will store each number from A+K right to left
        List<Integer> result = new ArrayList();
        
        //We will add K to each position of array from right to left
        int curr = K;
        
        while(--n >= 0 || curr > 0){
            
            //If we have not traversed through each index of array
            if(n >= 0){
                
                curr += A[n];
            }
            
            //We add the LSB of the result to list
            result.add(curr % 10);
            
            //Since we added last digit, remove it
            curr /= 10;
        }
        
        Collections.reverse(result);
        return result;
        
    }
}
