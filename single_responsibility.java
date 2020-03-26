/* 
 * 
 * Example for Single Responsibility princicle
 *
 */

//====================================================================================================================
// The matrix_manipulation class have to responsible for 3 task:
// 	1. Read a 3x3 matrix from file
// 	2. Performing matrix manipulation (transpose in this case) on the given matrix 
// 	3. Display the matrix on the screen
//====================================================================================================================
// input:
// 	3
// 	4
// 	5
// 	6
// 	7
// 	8
// 	9
// 	10
// 	11
//====================================================================================================================
// output:
// 	3 6 9
// 	4 7 10
// 	5 8 11
// ===================================================================================================================



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Bad example
//
//   The matrix manipulation class has to responsible for 3 different operations:
//     1. Read matix from file
//     2. Performming matrix manipulation on the given matrix
//     3. Displaying the matrix on the screen
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public class matrix_manipulation {
  static final int dimension = 3;

  private static void transpose(int[][] original_matrix, int[][] transposed_matrix){ 
    int row, column;
    for (row = 0; row < dimension; row++){
      for (column = 0; column < dimension; column++){
        transposed_matrix[i][j] = original_matrix[i][j]
      }
    }
  }

  private static void readFile(final Scanner scanner, final int[][] matrix) {
    for (int row = 0; i < matrix.length; row++) {
      for (int column = 0; j < matrix[row].length; column++) {
        if (scanner.hasNextInt()) {
          matrix[row][column] = scanner.nextInt();
	}
      }
    }
  }

  private static void main(String[] args) {

    int[][] original_matrix = new int[dimension][dimension];
    int[][] transposed_matrix = new int[dimension][dimension];

    readFile("Text.txt", original_matrix);

    transpose(original_matrix, transposed_matrix)

    for (int row = 0; row < dimension; row++) {
      for (int column = 0; column < dimension; column++) {
        System.out.print(transposed_matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Good example
//
//   The program will be divided into 3 classes responsible for 3 different operations:
//     1. Read 3x3 matix from file
//     2. Performming matrix manipulation on the given matrix
//     3. Displaying the matrix on the screen
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public class matrix_manipulation {

  private static final int dimension = 3;
   
  private static int[][] transpose(file_handling.readFile("text.txt")){ 
    int[][] transposed_matrix = new int[dimension][dimension];
    for (row = 0; row < dimension; row++){
      for (column = 0; column < dimension; column++){
        transposed_matrix[i][j] = original_matrix[i][j];
      }
    }
    return transposed_matrix;
  }

  private static find_rank(int[][] original_matrix) {
	 // this is operation find the rank of a 3x3 matrix 
  }

}

public class file_handling {

  private static int[][] readFile(final Scanner scanner) {
    int[][] matrix;
    for (int row = 0; i < matrix.length; row++) {
      for (int column = 0; j < matrix[row].length; column++) {
        if (scanner.hasNextInt()) {
          matrix[row][column] = scanner.nextInt();
	}
      }
    }
    return matrix;
  }
 
  private static int[][] writeFile(final Scanner scanner) {
    // This operation writes the given matrix from a to a file
  }
}

public class UI_handling {
  private static void main(String[] args) {
    int[][] matrix = new int[matrix_manipulation.dimension][matrix_manipulation.dimension];
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix.length; column++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
