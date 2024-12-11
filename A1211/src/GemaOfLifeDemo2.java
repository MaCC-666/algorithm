import java.util.Arrays;
public class GemaOfLifeDemo2 {
    public void gameOfLife(int[][] board)
    {
        if(board.length == 0 || board[0].length==0) return;
        int m = board.length, n = board[0].length;

        int[] neighbor = {0, 1, -1};
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] % 10 == 1)
                    for(int k = 0; k < 3; k++)
                        for(int l = 0; l < 3; l++)
                        {
                            int left = i + neighbor[k];
                            int right = j + neighbor[l];
                            if(neighbor[k] == 0 && neighbor[l] == 0)
                                continue;
                            if(left >= 0 && right >= 0 && left < m && right < n)
                                board[left][right] += 10;
                        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == 21 || board[i][j] == 31)
                    board[i][j] = 1;
                else if(board[i][j] == 30)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;


    }
}
