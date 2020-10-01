class Median2SortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        
        //We always keep the size of array1 < size of array2, because we will perform the binary search operation on smaller array
        if(m > n){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        //For finding the partition
        int low = 0;
        int high = m;
        
        //We will perform binary search of nums1
        while(low <= high){
            
            //EG:- partition :-0   1   2   3  4
            //     array     :- 23  26  31  35
            int partitionX = (low + high) / 2;
            
            //partitionX + partitionY = Avg(len X + len Y)
            //We do +1 cuz it should work for both even and odd length of combined array(nums1[] + nums2[]). In odd we make sure the extra 1 element falls in left partition. So total of 11 elements partn will be :- 6 and 5
            int partitionY = (m + n + 1)/2 - partitionX;
            
            //There should be equal number of elements on both left and right side
            //If total length is odd, then left side should have 1 extra element
            
            //If there is no elements of left side then we take -INF
            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE: nums1[partitionX - 1];
            
            //If there is no elements of right side then we take +INF
            int minRightX = (partitionX == m)? Integer.MAX_VALUE: nums1[partitionX];
            
            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE: nums2[partitionY - 1];
            
            int minRightY = (partitionY == n)? Integer.MAX_VALUE: nums2[partitionY];
            
            //If conditions are satisfied then all the elements in left of x + y <= all elements on right of x + y; so we can find the median 
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                
                //Even:- then we do avg of 2 mid elements to get median
                if((m + n) % 2 == 0){
                    
                    double val = Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY);
                    
                    return val / 2.0;
                }
                else{
                    
                    //Odd:- we just return middle value. Since in odd there will always be 1 extra element in left side of partition as we did +1 before while finding partition. That 1 element is median which is present in left partition.
                    
                    return (double)Math.max(maxLeftX,maxLeftY);
                    
                }
            }
            //We need to move partition of X more towards left to make it smaller
            else if(maxLeftX > minRightY){
                
                high = partitionX - 1;
                
            }
            //if(maxLeftY > minRightX)
            else{
                
                //We move partition of X more towards right to make partition of Y smaller
                low = partitionX + 1;
            }
            
            
        }
        
        return 0.0;
        
    }
}
