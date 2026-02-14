public class DutchFlag {
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,2};
        for(int x : sortColors(a)){
            System.out.print(x+",");
        }
    }

    public static int[] sortColors(int[] nums) {
        int mid = 0;
        int left = 0;
        int right= nums.length-1;
        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                mid++;
                continue;
            }

            if(nums[mid] == 1){
                mid++;
                continue;
            }

            if(nums[mid] == 2){
                int temp=nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }
}