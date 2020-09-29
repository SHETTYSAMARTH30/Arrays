class Pair{
    
    int time;
    String web;
    
    public Pair(int time, String web){
        
        this.time = time;
        this.web = web;
    }
}

class UserWebsiteVisit {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        //key = username, value = (time,website)
        Map<String, List<Pair>> map = new HashMap<>();
        
        int n = username.length;
        
        for(int i = 0; i < n; i++){
            
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i],website[i]));
        }
        
        //We store the count of all the 3 sequence string
        Map<String, Integer> count = new HashMap<>();
        
        //Stores resultant string
        String res = "";
        
        for(String key : map.keySet()){
            
            //Stores all the unique 3 seq for each user
            Set<String> set = new HashSet<>();
            
            //Fetches all (timestamp, website) of a user
            List<Pair> list = map.get(key);
            
            //We will sort the list according to timestamp
            Collections.sort(list, (a,b) -> a.time - b.time);
            
            //Creating 3 site sequence for a particular user; O(n ^ 3)
            
            for(int i = 0; i < list.size(); i++){
                
                for(int j = i + 1; j < list.size(); j++){
                    
                    for(int k = j + 1; k < list.size(); k++){
                        
                        StringBuilder sb =new StringBuilder();
                        
                        //We will create 3 seq string
                        sb.append(list.get(i).web).append(" ").append(list.get(j).web).append(" ").append(list.get(k).web);
                        
                        String s = sb.toString();
                        
                        //If we saw String for 1st time then save it
                        if(!set.contains(s)){
                            
                            count.put(s, count.getOrDefault(s,0)+1);
                            set.add(s);
                        }
                        
                        if(res.equals("") || count.get(res) < count.get(s) || (count.get(res) == count.get(s) && res.compareTo(s) > 0)){
                            
                            //If count of string > count of result then save strinh
                            //If count is same then lexicographically smaller string is the result
                            res = s;
                        }
                    }
                }
            }
            
        }
        
        String result[] = res.split(" ");
        List<String> ans = new ArrayList<>();
        
        for(String s : result){
            ans.add(s);
        }
        
        return ans;
        
    }
}
