public class RemoveDuplicatesDemo1 {
    /*
    *
    * 示例 1：
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，
* 并且原数组 nums 的前两个元素被修改为 1, 2 。
* 不需要考虑数组中超出新长度后面的元素。*/
    /*
    1 <= nums.length <= 3 * 104
            -104 <= nums[i] <= 104
    nums 已按 非严格递增 排列
    */
    public int removeDuplicates(int[] nums) {
        if(nums.length==1)
            return 1;
        int i=0;
        int j=1;
        while (j<nums.length){
            //易错点：做算法题先考虑题目的极端有特色的案例情况
            while (j<nums.length&&nums[i]==nums[j]){
                j++;
            }
            if(j==nums.length)
                break;
            nums[++i]=nums[j++];
        }
        return nums.length-(j-i-1);
    }

}
