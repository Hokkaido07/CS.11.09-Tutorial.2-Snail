public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {

        if(array2d == null ||!isPerfectSquare(array2d) ){
            return new int[0];
        }

        int n = array2d.length;
        int[] result = new int[n * n];
        int index = 0;
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                result[index++] = array2d[startRow][i];
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                result[index++] = array2d[i][endCol];
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result[index++] = array2d[endRow][i];
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result[index++] = array2d[i][startCol];
                }
                startCol++;
            }
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {

        if (array1d == null) {
            return new int[0][0];
        }
        int length = array1d.length;
        int size = (int) Math.sqrt(length);

        if (size * size != length) {
            return new int[0][0];
        }

        int[][] snail = new int[size][size];

        int rowStart = 0;
        int rowEnd = size - 1;
        int colStart = 0;
        int colEnd = size - 1;
        int index = 0;

        while (index < length) {

            for (int i = colStart; i <= colEnd; i++) {
                snail[rowStart][i] = array1d[index++];
            }
            rowStart++;


            for (int i = rowStart; i <= rowEnd; i++) {
                snail[i][colEnd] = array1d[index++];
            }
            colEnd--;


            for (int i = colEnd; i >= colStart; i--) {
                snail[rowEnd][i] = array1d[index++];
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                snail[i][colStart] = array1d[index++];
            }
            colStart++;
        }

        return snail;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for(int i = 0; i<array1d.length; i++){
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {

    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        for(int i = 0;i<array1d.length;i++){
            if(array1d.length-1 == 9){
                return true;
            }
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {

        int rows = array2d.length;
        int columns = array2d[0].length;

        if (rows != columns) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            if (array2d[i].length != columns) {
                return false;
            }
        }

        return true;
    }


}
