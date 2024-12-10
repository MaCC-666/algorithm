package rectangle;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//扩展；逆时针90度，顺时针180,顺时针270
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
public class rotateDemo1
{
    public static void main(String[] args) {
        int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
       rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void rotate (int[][] matrix){
        /*
         *      1   2   ->  3   1
         *      3   4       4   2
         *
         *      4   3
         *      2   1
         *1.先主对角线对称,再左右对称
         *
         * */
        if(matrix.length==0)
            return;
        int r=matrix.length;
        int c=matrix[0].length;
        /*1.两个for循环均对半，则只有近四分之一的数被循环
        * 2.swap函数不影响外部，值传递
        * 3.已经交换过的值避免再次进入for循环被交换复原
        * 4.已经确定好为n*n矩阵
        * */

        //主对角线对称,注意避免重复,
        // 所以不可直接for循环从第一行顺序从左向右逐层遍历一半的数，
        // 而应该遍历上三角形
        for (int i = 0; i < r; i++) {
            for (int j = i+1; j < c; j++) {
               int temp=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= (c-1)/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][c-1-j];
                matrix[i][c-1-j]=temp;
            }
        }
    }
   /* public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    */
}
