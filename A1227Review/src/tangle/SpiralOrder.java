package tangle;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]m == matrix.length
    //n == matrix[i].length
    //1 <= m, n <= 10
    //-100 <= matrix[i][j] <= 100
    public List<Integer> spiralOrder(int[][] matrix) {
        //思路；设置边界线，每次走过一行就边界就缩小，按顺时针循环即可。
        //结束循环条件只要发生条件符号状态改变即可。<变成=或>都行
        //边界设置问题以及细节容易出错。
        List<Integer> list = new ArrayList<>();
        int t = 0;
        int l = 0;
        int b = matrix.length-1;
        int r = matrix[0].length-1;
       while (true){
           //for (int i = 0; i <= r; i++) {
           //i=l 而不是i=0,注意是l变量
           for (int i = l; i <= r; i++) {
               list.add(matrix[t][i]);//坐标勿混
           }
           if(++t>b) break;

           for (int i = t; i <= b; i++) {
               list.add(matrix[i][r]);
           }
           if(--r<l) break;//注意判断条件,不是--r>l

           for (int i = r; i>=l; i--) {
               list.add(matrix[b][i]);
           }
           if(--b<t) break;
           for (int i = b; i>=t; i--) {
               list.add(matrix[i][l]);
           }
           if(++l>r) break;
       }
        return list;
    }
}
