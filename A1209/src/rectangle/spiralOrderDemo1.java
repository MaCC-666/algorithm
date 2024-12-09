package rectangle;
import java.util.ArrayList;
import java.util.List;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
/*
1.if(t==b) return arr;特殊情况一行一列则将不会走完，以及行列数的不同导致if判断失效

2.注意行列下标不要搞混

3.注意上下边界初始化的值，交在一条线的时候必须为同一值

4.if(t==b&&l==r)走完所有元素将还会打印

*/
public class spiralOrderDemo1 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<>();
        if(matrix.length==0)
            return null;
        int t=0;
        int b=matrix.length;
        int l=0;
        int r=matrix[0].length;

        while (t!=b&&l!=r){
            for (int i = l; i < r; i++) {
                arr.add(matrix[t][i]);
            }
            t++;
            //1.if(t==b) return arr;特殊情况一行一列则将不会走完
            if(t==b&&l==r)
                return arr;
            for (int i = t; i < b; i++) {
                arr.add(matrix[i][r-1]);
            }
            r--;
            if(t==b&&l==r)
                return arr;
            for (int i =r-1 ; i> l-1; i--) {
                arr.add(matrix[b-1][i]);//2.注意行列下标不要搞混
            }
            b--;
            if(t==b&&l==r)
                return arr;//3.注意上下边界初始化的值，交在一条线的时候必须为同一值
            for (int i = b-1; i > t-1; i--) {
                arr.add(matrix[i][l]);
            }
            l++;
        }
        return arr;
        //  matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
       List<Integer> arr= spiralOrder(matrix);
        System.out.println(arr.toString());
    }
}
