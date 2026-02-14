public class LC55 {
    /**
     * Jump game
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{2,5,1,0,4};
        boolean[] dp = new boolean[a.length];
        System.out.println(jumpGame1(a,0,dp));
    }

    public static boolean jumpGame(int[] a,int index){
        if(index >= a.length){
            return false;
        }

        if(index == a.length -1){
            return true;
        }

        for(int ind = index;ind <= Math.min(a.length-1, index+a[index]);ind++){
            if(jumpGame(a, ind+1)){
                return true;
            }
        }

        return false;
    }

    public static boolean jumpGame1(int[] a,int index,boolean[] dp){
        if(index >= a.length){
            return false;
        }

        if(index == a.length -1){
            dp[index] = true;
            return true;
        }

        if(dp[index] == true){
            return true;
        }

        for(int ind = index+1;ind <= Math.min(a.length-1, index+a[index]);ind++){
            if(jumpGame1(a, ind,dp)){
                dp[ind] = true;
                return true;
            }
        }
        dp[index] = false;
        return false;
    }
}
