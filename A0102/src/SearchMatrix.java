public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][c - 1] >= target){//注意判断条件
                for (int m = c - 1; m >= 0; m--) {
                    if (matrix[i][m] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
