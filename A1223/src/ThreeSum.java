import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    /*  例 1：
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
        示例 2：
        输入：nums = [0,1,1]
        输出：[]
        解释：唯一可能的三元组和不为 0 。
        示例 3：
        输入：nums = [0,0,0]
        输出：[[0,0,0]]
        解释：唯一可能的三元组和为 0 。
        提示：
        3 <= nums.length <= 3000
                -105 <= nums[i] <= 105*/
    public static List<List<Integer>> threeSum(int[] nums) {
        //1.先排序后好用三指针
        Arrays.sort(nums);
        int k = 0;
        //2.特判：第一个数>0，则无；
        if (nums[k] > 0) {//注意不能直接返回null
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        //3.当k在倒数第二个位置时，则可以直接return
        while (k <= nums.length - 3) {
            int i = k + 1;
            int j = nums.length - 1;//while循环注意越界
            while (k > 0 && k < nums.length && nums[k] == nums[k - 1]) {
                k++;
            }//注意加上下面合适的if判断，不然【0,0,0,0】出问题
            if (k >= nums.length - 2) {
                return lists;
            }
            while (i < j) {
                //此处不应该为if,且应该加个i<j，不然【0,0,0】出问题
                while (i < j && (nums[k] + nums[i] + nums[j]) == 0) {
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    //nums[++i] == nums[i]相当于nums[i+1] == nums[i+1]；i++；没赋值，必然的
                    while (i < j && nums[i] == nums[++i]) ;
                    while (j > i && nums[j] == nums[--j]) ;
                }
                //(下面两个while需要判断i,j关系)
                while (j > i && (nums[k] + nums[i] + nums[j]) < 0) i++;
                while (j > i && (nums[k] + nums[i] + nums[j]) > 0) j--;
            }
            k++;
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] nums={0,0,0};
        List<List<Integer>> lists=threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
