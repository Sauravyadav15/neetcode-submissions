class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map= new HashMap<>();
        int n= s.length();
        int start=0;int end=0;
        int maxCount=0;
        int ans=0;
        while(end<n){
            char c= s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            int len= end-start+1;
            if(map.get(c)>maxCount){
                maxCount= map.get(c);
            }
            if(len-maxCount>k){
                
               
               
                char sc= s.charAt(start);
                map.put(sc,map.get(sc)-1);
                start++;
            }
             ans= Math.max(ans,end-start+1);
            end++;
        }
        return ans;
    }
}