package doublepointer;
public class MaxArea {
    //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    //返回容器可以储存的最大水量。
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    //示例 2：

    //输入：height = [1,1]
    //输出：1

    //提示：
    //n == height.length
    //2 <= n <= 105
    //0 <= height[i] <= 104

    //if(height[i]<=height[j]){
    //                max=Math.max(max,(j-i)*height[i]);
    //                i++;
    //            }
    //            else {
    //                max=Math.max(max,(j-i)*height[j]);
    //                j--;
    //            }
    public int maxArea(int[] height) {
        int max=0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            max=Math.max(max,height[i]<=height[j]?
                            (j-i)*height[i++]:
                            (j-i)*height[j--]);
            //注意不可随意交换顺序，i++并不是在一个语句后才执行，而是在使用完后变执行
          //  error:
//                    height[i++]*(j-i):
//                    height[j--]*(j-i));
        }
        return max;
    }
}
