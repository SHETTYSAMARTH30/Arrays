class Partition3Parts {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        
        //Find the total
        for(int i : arr){
            
            sum += i;
        }
        
        //Keeps sum of each part
        int partSum = 0;
        
        //Keeps the count of each part
        int count = 0;
        
        //Each part must have sum/3
        for(int i = 0; i < arr.length; i++){
            
            partSum += arr[i];
            
            //If we find a part then increment count and check for new part
            if(partSum == sum / 3){
                
                count++;
                partSum = 0;
            }
        }
        
        //Total parts must be 3 and the entire array must be scanned completely
        return (count >= 3 && partSum == 0);
        
    }
}
