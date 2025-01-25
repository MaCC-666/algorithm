public class Trap {
//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//    示例 1：
//
//    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出：6
//    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    public int trap(int[] height){
        //1.每个坑位的水都由前后缀max中较小的板子和自己板子高度决定
        //1.1 每个坑位的最大前后缀如何求得？前后双指针，谁小移谁。同时记录当前最大前后缀解决问题(被移的那侧肯定属于短板，再比较移动指针和那侧记录的最大值)
        //2.将每个坑位中的水相加即可

        //额外：如果双指针相等怎么移动？
        // (此时代表当前最高的两根，这两根坑位均无水，看似是移动任意一根或者同时移动都行，但是为了遵守双指针当中始终一根保持最大，就不同时移动了)

        int length=height.length;
        int preMax=height[0];
        int behMax=height[length-1];
        int sum=0;
        int i=0;
        int j=length-1;

        while (i<j){
            if(height[i]<height[j]){
               preMax=preMax>height[i]?preMax:height[i];
               sum+=preMax-height[i++];
            }
            else {
                behMax=behMax>height[j]?behMax:height[j];
                sum+=behMax-height[j--];
            }
        }
        return sum;

    }
}
