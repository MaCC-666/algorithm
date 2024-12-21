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
            if(nums[m]==0){
                while (i<nums.length&&nums[i]==0){//注意考虑极端情况，后面如果都是0的话，此循环必然会越界
                    i++;
                }
                //注意考虑极端情况，后面如果都是0的话，此循环必然会越界
                if(i<nums.length){
                    nums[m]=nums[i];
                    nums[i]=0;
                }
            }
            m++;
        }
    }
}
