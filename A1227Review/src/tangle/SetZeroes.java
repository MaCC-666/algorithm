package tangle;
public class SetZeroes {

//        m == matrix.length
//        n == matrix[0].length
//        1 <= m, n <= 200
//                -231 <= matrix[i][j] <= 231 - 1
//        给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//        思路：直接遍历遇0将行列设0肯定不行，会影响后续判断，(23min22s)
//        又题目要求原地算法，那么进一步考虑是否可以将元素为0，其行列需要设为0的位置给存储下来，最后再遍历根据要求设0即可；
//        根据特点：在同一行的话只要有一个0，那么这行所有元素都要设为0，如果有一个以上的0的话，相当于重复给这一行设0了，
//        那么可以考虑将行首位置去存储该行是否需要置0，同理，列首位置存储该列是否需要设置为0.
//        最后根据遍历行首和列首去将相对应的行和列置0。
//        易错点：1.行首和列首均用于存储了其行或列是否需要置0，
//        但是行首和列首本身是否有零就会被忽略，所以开始前先遍历行列首，用变量存储行列首是否需要置零。
//        2.注意先开始遍历行首时，应该从第二行开始，不然当matrix[0,0]=0会影响后面列首的判断。
public static void setZeroes(int[][] matrix) {
        boolean rowHead=false;
        boolean columnHead=false;
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                rowHead=true;
                break;
            }
            }
        for (int j = 0; j < n; j++) {
            if(matrix[0][j]==0){
                columnHead=true;
                break;
            }
        }
        if(m>=2&&n>=2){
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if(matrix[i][j]==0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }
        //注意先开始遍历行首时，应该从第二行开始，不然当matrix[0,0]=0会影响后面列首的判断。
        for (int i = 1; i < m; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if(matrix[0][j]==0){
                for (int i = 0; i < m; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        if(rowHead){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
        if(columnHead){
            for (int j = 0; j < n; j++) {
                matrix[0][j]=0;
            }
        }
    }//(17min)+debug(20min)
    public static void main(String[] args) {
        int [][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }
}
