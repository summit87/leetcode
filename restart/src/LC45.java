public class LC45 {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(jump(a));
    }

    private static int minJump(int[] a,int index){
        if(index >= a.length){
            return Integer.MAX_VALUE;
        }

        if(index == a.length-1){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int ind = index+1;ind <= Math.min(a.length-1, index+a[index]);ind++){
            min = Math.min(min, 1+minJump(a, ind));
        }

        return min;
    }

    private static int jump(int[] a){
        int ans = 0;
        int st = 0;
        int end = 0;
        for(int i=0;i<a.length-1;i++){
            st = Math.max(st, i+a[i]);
            if(i == end){
                ans++;
                end = st;
            }
        }
        return ans;
    }
}
