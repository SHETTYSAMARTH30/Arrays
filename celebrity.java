/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class celebrity extends Relation {
    
    int numOfPeople;
    public int findCelebrity(int n) {
        
        numOfPeople = n;
        
        int celebCandidate = 0;
        for(int i=1; i < n; i++){
            if(knows(celebCandidate,i)){
                celebCandidate = i;
            }
        }
        
        if(isCelebrity(celebCandidate)){
            return celebCandidate;
        }
        
        return -1;
        
    }
    
    public boolean isCelebrity(int i){
        
        for(int j=0; j < numOfPeople; j++){
            
            if(i == j)
                continue;
            
            if(knows(i,j) || !knows(j,i))
                return false;
            
        }
        
        return true;
    }
}
