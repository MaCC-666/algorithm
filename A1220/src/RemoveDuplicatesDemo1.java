public class RemoveDuplicatesDemo1 {
//    示例 1：
//
//    输入：nums = [1,1,1,2,2,3]
//    输出：5, nums = [1,1,2,2,3]
//    解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
//    示例 2：
//    输入：nums = [0,0,1,1,1,1,2,3,3]
//    输出：7, nums = [0,0,1,1,2,3,3]
//    解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
//    提示：
//            1 <= nums.length <= 3 * 104
//            -104 <= nums[i] <= 104
//    nums 已按升序排列
    public int removeDuplicates(int[] nums) {
        return process(nums,2);
    }
    public int process(int[] nums,int k){
        if(nums.length<=k){
            return nums.length;
        }
        int i=k;//i=0?
        int j=k;
        int count=0;//计数器，计算已经移除的数字个数
        while (j<nums.length){
            //1.移除了元素后
            //2.正常情况
            while (nums[j]==nums[j-k]){
                count++;
                j++;
            }
            i=j-count;
            nums[i++]=nums[j++];
        }
        return nums.length-count;
    }
}
