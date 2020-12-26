class KConsecutivePatterns {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        //We check first num of 1st grp with 2nd num of 2nd grp and so on
        int count = 0;
        
        //We stop at 2nd last grp of len m
        for(int i = 0; i < arr.length - m; i++){
            
            //Check each number in a grp with next consecutive subarray
            count = (arr[i] == arr[i + m]) ? count + 1 : 0;
            
            //If we found pattern of len m repeated k times then return true
            //Imagine this as m * k 2D array. The number of comparisons in this will be m*(k-1), so if m*(k-1) counts are same then we get the result.
            if(count == (k - 1) * m)
                return true;
        }
        
        return false;
    }
}
