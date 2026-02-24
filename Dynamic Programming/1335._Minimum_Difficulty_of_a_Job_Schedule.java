// Brute Force :- Only recursion
class Solution {
    
    public int minDifficulty(int[] arr, int d) {
        if(arr.length<d) return -1;

        int n = arr.length;
        return solve(arr,n,0,d);
    }
    int solve(int[] arr, int n , int i, int d){
        if(d==1){
            int maxD = arr[i];
            for(int j = i;j<n;j++){
                maxD = Math.max(maxD,arr[j]);
            }
            return maxD;
        }
        int maxD = arr[i];
        int finalR = Integer.MAX_VALUE;
        for(int idx = i;idx<=n-d;idx++){
            maxD = Math.max(maxD,arr[idx]);
            int res = maxD+solve(arr,n,idx+1,d-1);
            finalR = Math.min(finalR,res);
        }
        return finalR;
    }
}

//Optimal Using memo
class Solution {
    int[][] dp;
    public int minDifficulty(int[] arr, int d) {
        if(arr.length<d) return -1;
        dp = new int[301][11];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        int n = arr.length;
        return solve(arr,n,0,d);
    }
    int solve(int[] arr, int n , int i, int d){
        if(d==1){
            int maxD = arr[i];
            for(int j = i;j<n;j++){
                maxD = Math.max(maxD,arr[j]);
            }
            return maxD;
        }
        if(dp[i][d]!=-1){
            return dp[i][d];
        }
        int maxD = arr[i];
        int finalR = Integer.MAX_VALUE;
        for(int idx = i;idx<=n-d;idx++){
            maxD = Math.max(maxD,arr[idx]);
            int res = maxD+solve(arr,n,idx+1,d-1);
            finalR = Math.min(finalR,res);
        }
        return dp[i][d]=finalR;
    }
}
