class ReorderData {
    public String[] reorderLogFiles(String[] logs) {
        
        //1. The letter logs should come before the digit logs
        //2. Letter logs are sorted alphanumerically, If tie then check by identifier
        //3. Digit logs should be in original order
        
        //We will sort the array logs, acc to custom comparison rules in compare() mtd
        Arrays.sort(logs, new Comparator<String>(){
            
            //We have used the anonymous class and we override compare() mtd from Comparator Interface by implementing it
            //It takes 2 parameters of Array at a time
            public int compare(String log1, String log2){
                
                //It divides string array into first blank space ie after identifier
                String[] split1 = log1.split(" ",2);
                String[] split2 = log2.split(" ",2);
                
                //We check whether 1st letter after identifier,is digit or not
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                //If both of them is letter then compare lexicographically
                if(!isDigit1 && !isDigit2){
                    
                    int cmp = split1[1].compareTo(split2[1]);
                    
                    //If not equal return result
                    if(cmp != 0)
                        return cmp;
                    
                    //If equal then compare by identifier
                    //If split1 < split 2 then return -1 else +1
                    return split1[0].compareTo(split2[0]);
                }
                
                //If both of them are digits then return 0 so that positions dont change
                //If isDigit1 is true and isDigit2 is false then we need isDigit2 before isDigit1 coz it is letter hence 1
                //If isDigit1 is letter then we return -1 cuz letter comes before digit
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                
            }
        });
        
        return logs;
        
    }
}
