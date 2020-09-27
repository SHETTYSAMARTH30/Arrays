class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // Iterate over each of the elements in the original array
        for(int i = 0; i < nums.length; i++){
            
            // Treat the value as the new index
            int index = Math.abs(nums[i])-1;
            
            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative 
            // thus indicating that the number nums[i] has 
            // appeared or has been visited
            //We negate the number present at the index-1, at the end whichever index is not negative its index-1 is not present in array
            if(nums[index] > 0)
                nums[index] *= -1;
                
        }
        
        // Response array that would contain the missing numbers
        List<Integer> list = new ArrayList<>();
        
        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for(int i = 1; i <= nums.length; i++){
            
            //If the number is negative then it means its index-1 is present in array and if its +ve then its index-1 was not present hence we did not negate its value
            if(nums[i - 1] > 0)
                list.add(i);
        }
        
        return list;
        
    }
}
