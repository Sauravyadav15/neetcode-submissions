class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int counter=0;
        int max=0;
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        char[] ca= s.toCharArray();
        while(end<n){
            map.put(ca[end],map.getOrDefault(ca[end],0)+1);
            counter++;
           // if the last char we have added is duplicate, then decrease the counter, decrease teh count inside map by one and increase teh start or left pointer.
                while(map.get(ca[end])>1){
                    counter--;
                    map.put(ca[start],map.get(ca[start])-1);
                    start++;
                }
            
            
            max= Math.max(max, counter);
            end++;
        }
        return max;
    }
}