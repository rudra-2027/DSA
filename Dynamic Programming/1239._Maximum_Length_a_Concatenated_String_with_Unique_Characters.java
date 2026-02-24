// Brute Force 
class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr,0,"");
    }
    int solve(List<String> arr, int idx, String temp){
        if(idx==arr.size()){
            return temp.length();
        }
        int skip = solve(arr,idx+1,temp);
        String curr = arr.get(idx);
        int take = 0;
        if(check(curr,temp)){
            take = solve(arr,idx+1,temp+curr);
        }
        return Math.max(take,skip);
    }
    boolean check(String s1, String s2){
        Set<Character> hs = new HashSet<>();
        for(char c :s1.toCharArray()){
            if(hs.contains(c)){
                return false;
            }
            hs.add(c);
        }
        for(char c :s2.toCharArray()){
            if(hs.contains(c)){
                return false;
            }
            hs.add(c);
        }
        return true;
    }
}

// Optimal using memo

class Solution {
    HashMap<String,Integer> hm = new HashMap<>();
    public int maxLength(List<String> arr) {
        return solve(arr,0,"");
    }
    int solve(List<String> arr, int idx, String temp){
        if(idx==arr.size()){
            return temp.length();
        }
        String key = idx+"_"+temp;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        int skip = solve(arr,idx+1,temp);
        String curr = arr.get(idx);
        int take = 0;
        if(check(curr,temp)){
            take = solve(arr,idx+1,temp+curr);
        }
        int ans = Math.max(take,skip);
        hm.put(key,ans);
        return ans;
    }
    boolean check(String s1, String s2){
        Set<Character> hs = new HashSet<>();
        for(char c :s1.toCharArray()){
            if(hs.contains(c)){
                return false;
            }
            hs.add(c);
        }
        for(char c :s2.toCharArray()){
            if(hs.contains(c)){
                return false;
            }
            hs.add(c);
        }
        return true;
    }
}
