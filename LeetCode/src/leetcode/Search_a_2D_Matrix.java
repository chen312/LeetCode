package leetcode;

/**
 * @author Sunshine
 */
public class Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int low1 = 0, low2 = 0, high1 = matrix.length-1, high2 = matrix[0].length-1;
        while (high1 >= low1){
            int middle1 = (high1+low1) / 2;
            if (matrix[middle1][0] <= target && (middle1 == matrix.length-1 || matrix[middle1+1][0] > target)){
                while (high2 >= low2){
                    int middle2 = (low2+high2) / 2;
                    if (matrix[middle1][middle2] == target)
                        return true;
                    else if (matrix[middle1][middle2] > target){
                        high2 = middle2 - 1;
                    }
                    else
                        low2 = middle2 + 1;
                }
                return false;
            }
            else if (matrix[middle1][0] > target){
                high1 = middle1 - 1;
            }
            else
                low1 = middle1 + 1;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1}};
        int target = 1;
        System.out.println(searchMatrix(matrix, target));
    }
}
