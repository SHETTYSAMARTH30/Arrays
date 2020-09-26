class UniqueNumberNotRepeating {
    public int largestUniqueNumber(int[] A) {
        
        Map<Integer, Integer> occ = new HashMap<>();
        
        for(int a : A){
            occ.put(a, occ.getOrDefault(a,0) + 1);
        }
        
        int max = -1;
        
        for(int a : A){
            
            if(occ.get(a) == 1 && a > max)
                max = a;  
        }
        
        return max;
    }
}
