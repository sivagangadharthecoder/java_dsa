import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    public static void main(String[] args) {
        String[][] matrix = {
                { "vi", "ka", "ta" },
                { "ka", "vi", "ka" },
                { "ta", "ka", "vi" }
        };
        List<String> result = spiralOrder(matrix);
        System.out.println(result);
    }

    private static List<String> spiralOrder(String[][] matrix) {
        List<String> list = new ArrayList<>();

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return list;
    }
}
