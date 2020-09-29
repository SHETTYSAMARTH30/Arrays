class 2SumSorted {
    public int[] twoSum(int[] numbers, int target) {
        
        int low = 0;
        int high = numbers.length - 1;
        
        while(low < high){
            
            int sum = numbers[low] + numbers[high];
            
            if(sum > target){
                
                high--;
            }
            else if(sum < target){
                
                low++;
            }
            //If its equal then return indexes
            else{
                return new int[]{low + 1, high + 1};
            }
        }
        
        return new int[]{-1,-1};
    }
}
