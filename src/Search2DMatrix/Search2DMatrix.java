package Search2DMatrix;

public class Search2DMatrix {

    private int[][] array;

    public Search2DMatrix (int[][] array) {
        this.array = array;
    }

    public boolean searchMatrix(int target) {
        if (array == null) {
            return false;
        }

        return binarySearch(target);
    }

    private boolean binarySearch(int target) {
        int m = array.length;
        int n = array[0].length;
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int middle = low + ( (high - low) / 2); // (low + high) / 2

            int row = middle / n;
            int col = middle % n;

            int value = array[row][col];

            if (value == target) {
                return true;
            }

            if (value < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        System.out.println(new Search2DMatrix(array).searchMatrix(70));
    }

}
