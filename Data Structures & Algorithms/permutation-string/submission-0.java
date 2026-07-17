class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k= s1.length();
        int n=s2.length();
        int start=0;int end=0;
        boolean ans= false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            char c= s1.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int len=map.size();
        while(end<n){
            char ec=s2.charAt(end);
            if(map.containsKey(ec)){
                map.put(ec,map.get(ec)-1);
                if(map.get(ec)==0) len--;
            }
            
            if(end - start + 1 > k){
                char sc= s2.charAt(start);
                if(map.containsKey(sc)){
                    if(map.get(sc)==0) len++;
                    map.put(sc,map.get(sc)+1);
                }
                start++;
            }
            
            if(len == 0) return true;
            end++;
        }
        return ans;
    }
}