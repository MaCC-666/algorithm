public class GameOfLifeDemo1 {
    /*给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
    每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
    每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
给定当前 board 的状态，更新 board 到下一个状态。
注意 你不需要返回任何东西。*/
    public static void gameOfLife(int[][] board) {
        int r=board.length;
        int c=board[0].length;
        /*if(c==0)
            return;*/
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int m = -1; m < 2; m++) {
                    if(i+m<0||i+m>=r)
                        continue;
                    for (int n = -1; n < 2 ; n++) {
                        if(m==0&&n==0||j+n<0||j+n>=c)
                            continue;
                        board[i+m][j+n]+=10;
                    }
                }
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int value=board[i][j];
                if((value%10==1&&(value/10==2)) ||(value/10==3)){
                    board[i][j]=1;
                }
                else board[i][j]=0;
            }
        }

    }
    public static void main(String[] args) {
        int [][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
