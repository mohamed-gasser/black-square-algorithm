
package task.test;
import java.io.* ;
import java.util.*;
import java.lang.*;

public class TaskTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        
        
        System.out.println("enter the value of the row and colum of the matrix : ");
        int N =input.nextInt();
      
        int[][] my_array = new int[N][N];
        int A[] = {3,3,3,5,4};

        System.out.println("enter the value of the array : ");
        for (int i = my_array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= my_array[i].length - 1; j++) {
                if (A[j] >= 1) {
                    my_array[i][j] = 1;
                    A[j] = A[j] - 1;
                } 
                else {
                    my_array[i][j] = 0;
                }
            }

        }
        System.out.println("  ");
        for (int i = 0; i <= my_array.length - 1; i++) {
            for (int j = 0; j <= my_array[i].length - 1; j++) {
                System.out.print(my_array[i][j] + " ");
            }
            System.out.println("");

        }

        System.out.println("the Largest Square Side in matrix is : " + LargestSquareSide(my_array));

    }
    
    static int LargestSquareSide(int matrix[][]){

        int maxsqlen = 0;
        int rows = matrix.length, cols =  matrix[0].length ;
   
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                if (matrix[i][j] == 1) {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == 1) {
                                flag = true;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen ;
    }
}
