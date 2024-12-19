import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        //示例 1：
        //
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        //示例 2：
        //
        //输入：nums = [3,2,4], target = 6
        //输出：[1,2]
        //示例 3：
        //
        //输入：nums = [3,3], target = 6
        //输出：[0,1]

        //提示：
        //
        //2 <= nums.length <= 104
        //-109 <= nums[i] <= 109
        //-109 <= target <= 109
        //只会存在一个有效答案
        //
        //
        //进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

        /*
        * 1.for循环嵌套简单
        * 2.两个for循环也可
        * 3.思考一下能否用一个for循环？
        * */
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if(!map.isEmpty()&&(nums[i])==map.containsKey(target-nums[i]))
            //map.containsKey返回的是布尔值，这样编译会报错的
            if(!map.isEmpty()&&map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i );
        }
       // throw new Exception("该数组中无符合要求的数");
        throw new IllegalArgumentException("No two sum solution");
    }
}
