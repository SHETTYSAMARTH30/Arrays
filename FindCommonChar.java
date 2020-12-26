class FindCommonChar {
    public List<String> commonChars(String[] A) {
        
        //To store frequency of any of 26 alphabets
        int[] frequency1 = new int[26];
        
        int[] frequency2 = new int[26];
        
        //We save the frequency of all the characters of A[0]
        for(char c : A[0].toCharArray()){
            
            frequency1[c - 'a']++;
        }
        
        for(int i = 1; i < A.length; i++){
            
            //We save the frequency of each characters in String
            for(char c : A[i].toCharArray()){
                
                frequency2[c - 'a']++;
            }
            
            //We will then compare frequency of each characters in both arrays and store the min count. In this way, if a letter doesn't exist in 1 string it will become 0 in result due to min.
            for(int j = 0; j < frequency1.length; j++){
                
                frequency1[j] = Math.min(frequency1[j], frequency2[j]);
                
                frequency2[j] = 0;
            }
            
        }
        
        //Store the result
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < frequency1.length; i++){
            
            //Get the character that we want to save
            char c = (char)(i + 'a');
            
            //Add each character j (frequency) times in result
            for(int j = 0; j < frequency1[i]; j++){

                //Add to result
                result.add(Character.toString(c));
            }
            
        }
        
        return result;
        
    }
}
