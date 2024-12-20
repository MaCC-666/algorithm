public class MoveZeroesDemo1 {
    //    示例 1:
//    输入: nums = [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//    示例 2:
//    输入: nums = [0]
//    输出: [0]
//    提示:
//            1 <= nums.length <= 104
//            -231 <= nums[i] <= 231 - 1

    //bug版本
    public void moveZeroes(int[] nums) {
        //1.双指针遇0交换
        int m=0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                m=i;
                while (nums[i]==0){
                    i++;
                }
                nums[m]=nums[i];
                nums[i]=0;
            }
            m++;
        }
    }
}
