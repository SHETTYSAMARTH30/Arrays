class TopFiveMarks {
    public int[][] highFive(int[][] items) {
        
        //We will sort the array
        //Sort it in ascending order for student ids and if ids are same then sort them in descending order of marks
        
        Arrays.sort(items, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        /*Arrays.sort(items, new Comparator<int[]>(){
        
        public int compare(int[] a, int[] b){
            
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else{
                return a[0] - b[0];
            }
        }
        }); */
        
        //We will count the total students (we do this incase the stud ids are not consecutive)
        int id = 1;
        
        for(int i = 1; i < items.length; i++){
            
            if(items[i][0] != items[i-1][0])
                id++;
        }
        
        //No of rows = no of students, no of cols = 2
        int result[][] = new int[id][2];
        
        int sum = items[0][1], count = 1, index = 0;
        
        for(int i = 1; i < items.length; i++){
            
            //New student data
            if(items[i][0] != items[i-1][0]){
                
                sum = items[i][1];
                count = 1;
            }
            //If there are more than 5 marks we ignore it
            else if(count == -1)
                continue;
            
            //If the student id has not changed
            else if(items[i][0] == items[i-1][0]){
                
                sum += items[i][1];
                count++;
            }
            
            //If 5 marks are calculated then find average and store it in result
            if(count == 5){
                
                int avg = sum / count;
                sum = 0;
                count = -1;
                result[index++] = new int[]{items[i][0], avg};
            }
        
        }
        
        return result;
    }
}
