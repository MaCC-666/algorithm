package hash;

import java.util.HashSet;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
//        给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//        请你设计并实现时间复杂度为 O (n) 的算法解决此问题。
//        示例 1：
//
//        输入：nums = [100, 4, 200, 1, 3, 2]
//        输出：4
//        解释：最长数字连续序列是[1, 2, 3, 4]。它的长度为 4。
//        示例 2：
//
//        输入：nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
//        输出：9
//
//        提示：
//        0 <= nums.length <= 105
//        - 109 <= nums[i] <= 109
        if (nums.length <= 1) {
            return nums.length;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 1;

        for (int num : nums) {
            int count = 1;

            if (!set.contains(num - 1)) {
                //注意是++num,而不是num+1
                //while (set.contains(num+1))
                while (set.contains(++num)) {
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println( longestConsecutive(nums));
    }

}
