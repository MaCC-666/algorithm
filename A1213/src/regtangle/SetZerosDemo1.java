package regtangle;

public class SetZerosDemo1 {
    // 给定一个 m x n 的矩阵，如果一个元素为 0 ，
    // 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

//    m == matrix.length
//    n == matrix[0].length
//1 <= m, n <= 200
//            -231 <= matrix[i][j] <= 231 - 1

    public void setZeroes(int[][] matrix) {
        /*思路：
        * 1.如果先操作前面的元素则会对后面元素覆盖从而造成影响，则可以考虑存储。
        * 2.采取原地O(1)操作，则可以考虑存储到行首和列首
        * 3.特殊情况，只有一行或一列
        * 4.注意[0][0]这个相交位置
        * */
        boolean rowHead = false;
        boolean columnHead = false;

        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                rowHead = true;
            }
        }
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                columnHead = true;
            }
        }
        //要考虑特殊情况
        if(r>=2&&c>=2){
            for (int i = 0; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    if(matrix[i][j]==0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }
        }
        //注意开始扫描行首和列首时，i，j应该从1开始，不然会影响后续判断（跳过[0][0]）
        for (int j = 1; j < c; j++) {
            if(matrix[0][j]==0){
                for (int i = 0; i < r; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < c; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        if(rowHead){
            for (int i = 0; i < r; i++) {
                matrix[i][0]=0;
            }
        }
        if(columnHead){
            for (int i = 0; i < c; i++) {
                matrix[0][i]=0;
            }
        }
    }
}
