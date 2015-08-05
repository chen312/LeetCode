package leetcode;

/**
 * @author Sunshine
 */
public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    mark(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void mark(char[][] grid, int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            if (grid[x][y] == '0')
                return;
            else{
                grid[x][y] = '0';
                mark(grid, x+1, y);
                mark(grid, x-1, y);
                mark(grid, x, y+1);
                mark(grid, x, y-1);
            }
        }
    }
    
    public static void main(String[] args) {
        Number_of_Islands test = new Number_of_Islands();
    }
}
