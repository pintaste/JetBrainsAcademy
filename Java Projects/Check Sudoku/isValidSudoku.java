import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static boolean isValidSudoku(int[][] board, int n) {
        for (int i = 0; i < n * n; i++) {
            HashSet<String> row = new HashSet<>();
            HashSet<String> column = new HashSet<>();
            HashSet<String> block = new HashSet<>();
            for (int j = 0; j < n * n; j++) {
                if (!row.add(Integer.toString(board[i][j]))) {
                    return false;
                }
                if (!column.add(Integer.toString(board[j][i]))) {
                    return false;
                }
                int rowIndex = n * (i / n) + j / n;
                int colIndex = n * (i % n) + j % n;
                if (!block.add(Integer.toString(board[rowIndex][colIndex]))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                if (board[i][j] > n * n) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][]arr = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n*n; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        if (isValidSudoku(arr,n)) {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
