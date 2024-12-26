public class Trap {
    public int trap(int[] height) {
//        思路：将一整个区域分成若干个小区域看，高低起伏，
//        1.记录每个板子上的雨水数量，最后相加求和。h=板高
//         2.-->由于每个板子区间能装多少水取决于他的最大前缀板高和最大后缀板高，
//        3. 然后根据短板效应，则每个板子区间最多装-->如果min(前缀max，后缀max)>h？min-h:0;
//        4.由双指针双向移动，前指针所指向的板子的最大前缀值都已记录了，所以只需注意最大后缀即可，同理，后指针指向的板子也如此，
//        5.特点是：让前后指针相对较小的移动，因为已经较小的那个根据条件已经可以计算出装水量，可以进入下一个板子.
//        主要问题：1. 前后指针相等的话则移动哪个指针？移动一个还是两个？
//                2.先移动哪个指针？
//        解答问题：
//        (error)1.相等的话则意味着这两个板子的接水量一定为0，计算出该板子接水量后则都可以跳过，因为已经储存了最大前后缀值。
//        修正：(error)1.当二者相等时，此时可以均移动，但是这两个板子接水量由二者最大前后缀共同决定。
//        修正：1.当二者相等时，此时只能移动其中一个指针，但是这两个板子接水量由二者最大前后缀共同决定。
//        2.双指针初始化在首尾位置，通过5规则后再移动即可，不需考虑此问题。
//        总结：大拆小，由中间局部推整体区域。
//         每个板子区间能装多少水取决于他的最大前缀板高和最大后缀板高->本质是比较出最大前后缀谁是短板，再根据3计算。
//        易错点：1.当有两个移动指针时，容易惯性思维造成细节错误，比如i++,j++，但实际双向移动是j--
//        2.前后指针相等的情况容易判断失误，实际相等时只能移动其中一个指针，
//         当只有三个板子的时候，同时移动两个，会提前结束循环条件，那么中间的水会漏算
 //       height =[2,0,2]
        int preMax=height[0];
        int lastMax=height[height.length-1];
        int total=0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            preMax=Math.max(preMax,height[i]);
            lastMax=Math.max(lastMax,height[j]);
            int min= Math.min(preMax,lastMax);
            if(height[i]<height[j]){
                total+=height[i]<min?min-height[i]:0;
                i++;
            } else if (height[i]>height[j]) {
                total+=height[j]<min?min-height[j]:0;
                //j++注意是j--
                j--;
            }
            else {
                total+=min<height[i]?0:2*(min-height[i]);
                i++;
                //j--;
            }
        }
        return total;
    }
}
