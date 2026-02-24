//Brute Force
class Solution {
    public int nthUglyNumber(int n) {
       int cnt = 0;
        int num = 1;

        while(true){
            if(isUgly(num)){
                cnt++;
                if(cnt == n){
                    return num;
                }
            }
            num++;
        }
        
    }
    public boolean isUgly(int n){
        if(n<=0) return false;
        while(n%2==0) n/=2;
        while(n%3==0) n/=3;
        while(n%5==0) n/=5;
        return n==1;
    }
}

//Optimal Way
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n+1];
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            int u2 = arr[i2]*2;
            int u3 = arr[i3]*3;
            int u5 = arr[i5]*5;
            int min = Math.min(u2,Math.min(u3,u5));
            arr[i] = min;
            if(min==u2){
                i2++;
            }
            if(min==u3){
                i3++;
            }
            if(min==u5){
                i5++;
            }
        }
        return arr[n];
    }
}
