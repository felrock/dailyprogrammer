/******
 * 
 * 
 * [17-08-21] Challenge #328 [Easy] Latin Squares
 * 
 * *****/

package dailyprogrammer18;

import java.util.HashSet;
import java.util.Scanner;

public class LatinSquares {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        String numbers = scan.next();
        scan.close();
        int[][] test_case = new int[length][length];
        for(int i=0; i < length; i++){
            for(int j=0; j < length; j++){
                test_case[i][j] = Integer.parseInt(numbers.charAt(i+j)+"");
            }
        }
        System.out.println(isLatinSquare(test_case));
    }
    public static boolean isLatinSquare(int[][] matrix){
        HashSet<Integer> checkY = new HashSet<Integer>();
        HashSet<Integer> checkX = new HashSet<Integer>();
        for(int i=0; i < matrix.length; i++){
            checkY.clear();
            checkX.clear();
            for(int j=0; j < matrix[0].length; j++){
                if(checkX.contains(matrix[i][j])){
                    return false;
                }else{
                    checkX.add(matrix[i][j]);
                }
                if(checkY.contains(matrix[j][i])){
                    return false;
                }else{
                    checkY.add(matrix[j][i]);
                }
            }
        }
        return true;
    }
}
